
/**
 * 工具类
 */
public class XMLTools implements Serializable {

    public static HashMap<String, String> getXmlHead(String xmldoc) {

        // TODO Auto-generated method stub
        /** *用于存放节点的信息** */
        Map<String, String> map = new HashMap<String, String>();
        //        String childRootStr = "";
        try {
            //            /** *创建一个新的字符串*** */
            //            StringReader xmlReader = new StringReader(xmldoc);
            //            /** **创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入 */
            //            InputSource xmlSource = new InputSource(xmlReader);
            //            /** *创建一个SAXBuilder* */
            //            SAXBuilder builder = new SAXBuilder();
            //            /** *通过输入源SAX构造一个Document** */
            //            Document doc = builder.build(xmlSource);
            //            /** *获得根节点** */
            //            Element elt = doc.getRootElement();
            //            /** *获得BODY节点** */
            //            Element body = elt.getChild("head");
            //            /** *获得body节点下面的所有子节点*** */
            //            List<Element> child = body.getChildren();
            //            /** *遍历出body节点下面所有的子节点，节点名称和内容用put到map* */
            //            for (Element childEle : child) {
            //                map.put(childEle.getName(), childEle.getText());
            //            }

            //解析xml文件
            StringReader sr = new StringReader(xmldoc);
            InputSource is = new InputSource(sr);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document xml = builder.parse(is);
            //获取其根标签
            org.w3c.dom.Element languages = xml.getDocumentElement();
            //根据子标签进行查找，返回的是一个list集合
            NodeList list = languages.getElementsByTagName("head");
            org.w3c.dom.Element lan = (org.w3c.dom.Element) list.item(0);
            String code = lan.getElementsByTagName("code").item(0).getTextContent();
            map.put("code", code);
            String message = lan.getElementsByTagName("message").item(0).getTextContent();
            map.put("message", message);
            String rownum = lan.getElementsByTagName("rownum").item(0).getTextContent();
            map.put("rownum", rownum);
            System.out.println("返回数据-----" + WebserviceInit.getURLDecoderString(message));
            return (HashMap<String, String>) map;
        } catch (IOException e) {
            System.out.println("map IOException");
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        } catch (SAXException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> getXmlBody(String xmldoc) {
        // TODO Auto-generated method stub
        /** *用于存放节点的信息** */
        Map<String, String> map = new HashMap<String, String>();
        try {
            /** *创建一个新的字符串*** */
            StringReader xmlReader = new StringReader(xmldoc);
            /** **创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入 */
            InputSource xmlSource = new InputSource(xmlReader);
            /** *创建一个SAXBuilder* */
            SAXBuilder builder = new SAXBuilder();
            /** *通过输入源SAX构造一个Document** */
            Document doc = builder.build(xmlSource);
            /** *获得根节点** */
            Element elt = doc.getRootElement();
            /** *获得BODY节点下的vehispara节点** */
            Element body = elt.getChild("body").getChild("vehispara");
            /** *获得body节点下面的所有子节点*** */
            List<Element> child = body.getChildren();
            /** *遍历出body节点下面所有的子节点，节点名称和内容用put到map* */
            for (Element childEle : child) {
                map.put(childEle.getName(), childEle.getText());
            }
        } catch (JDOMException e) {
            // TODO Auto-generated catch block
            return null;
        } catch (IOException e) {
            System.out.println("map IOException");
            // TODO Auto-generated catch block
            return null;
        } catch (Exception e) {
            return null;
        }
        return map;
    }

    public static List<Map<String, String>> getXmlBodys(String xmldoc) {
        // TODO Auto-generated method stub
        /** *用于存放节点的信息** */
        List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
        try {
            /** *创建一个新的字符串*** */
            StringReader xmlReader = new StringReader(xmldoc);
            /** **创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入 */
            InputSource xmlSource = new InputSource(xmlReader);
            /** *创建一个SAXBuilder* */
            SAXBuilder builder = new SAXBuilder();
            /** *通过输入源SAX构造一个Document** */
            Document doc = builder.build(xmlSource);
            /** *获得根节点** */
            Element elt = doc.getRootElement();
            /** *获得BODY节点下所有的vehispara节点** */
            List<Element> bodyChildren = elt.getChild("body").getChildren("vehispara");
            for (Element bodyChild : bodyChildren) {
                Map<String, String> map = new HashMap<String, String>();
                /** *获得vehispara节点下所有子节点*** */
                List<Element> vehChildren = bodyChild.getChildren();
                for (Element vehChild : vehChildren) {
                    map.put(vehChild.getName(), vehChild.getText());
                }
                /** *将每一个vehispara最为Map放入List中*** */
                mapList.add(map);
            }
        } catch (JDOMException e) {
            // TODO Auto-generated catch block
            return null;
        } catch (IOException e) {
            System.out.println("map IOException");
            // TODO Auto-generated catch block
            return null;
        } catch (Exception e) {
            return null;
        }
        return mapList;
    }

}

