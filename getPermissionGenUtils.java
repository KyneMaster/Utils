	���������compile 'com.lovedise:permissiongen:0.0.6'
	/*��ȡ���Ȩ��*/
    private void getPermission() {
      if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
         PermissionGen.with(PaiZao.this)
               .addRequestCode(MY_PERMISSION_CODE)
               .permissions(
                     Manifest.permission.CAMERA,
                     Manifest.permission.WRITE_EXTERNAL_STORAGE
               )
               .request();
      }else{

      }
    }
   /*Ȩ�޷���*/
   @Override
   public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
      if (requestCode == MY_PERMISSION_CODE) {
         if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
               // TODO: Consider calling ActivityCompat#requestPermissions
               // 	here to request the missing permissions, and then overriding
               //   	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
               // 	to handle the case where the user grants the permission. See the documentation
               // 	for ActivityCompat#requestPermissions for more details.
               return;
            }else{
            }
         } else {
			//����ܾ���Ȩ�ޣ��ͻ�ص�������
            Toast.makeText(this, "����Ӧ�ù����д򿪡����������Ȩ�ޣ�", Toast.LENGTH_LONG).show();
            finish();
         }
         return;
      }
      super.onRequestPermissionsResult(requestCode, permissions, grantResults);
   } 