package service;

public class CalculatorAppInfo {
    public static final String quantity = "testdata.quantity";
    public static final String series = "testdata.series";
    public static final String instance = "testdata.instance";
    public static final String gpuType = "testdata.gpuType";
    public static final String gpuCount = "testdata.gpuCount";
    public static final String ssd = "testdata.ssd";
    public static final String location = "testdata.location";
    public static final String cud = "testdata.cud";


    public static String getQuantity(){
        return TestDataReader.getTestData(quantity);
    }

    public static String getseries(){
        return TestDataReader.getTestData(series);
    }

    public static String getInstance(){
        return TestDataReader.getTestData(instance);
    }

    public static String getGpuType(){
        return TestDataReader.getTestData(gpuType);
    }

    public static String getGpuCount(){
        return TestDataReader.getTestData(gpuCount);
    }

    public static String getSsd(){
        return TestDataReader.getTestData(ssd);
    }

    public static String getLocation(){
        return TestDataReader.getTestData(location);
    }

    public static String getCud(){
        return TestDataReader.getTestData(cud);
    }
}
