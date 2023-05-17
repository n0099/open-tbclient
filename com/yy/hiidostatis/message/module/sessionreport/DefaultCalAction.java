package com.yy.hiidostatis.message.module.sessionreport;
/* loaded from: classes10.dex */
public final class DefaultCalAction {
    public static final CalAction SUM = new CalAction() { // from class: com.yy.hiidostatis.message.module.sessionreport.DefaultCalAction.1
        @Override // com.yy.hiidostatis.message.module.sessionreport.CalAction
        public CalValue cal(Number number, CalValue calValue) {
            if (DefaultCalAction.isInt(number) && DefaultCalAction.isInt(calValue.value)) {
                return calValue.updateValue(Long.valueOf(DefaultCalAction.safeToInt(number) + DefaultCalAction.safeToInt(calValue.value)));
            }
            return calValue.updateValue(Double.valueOf(DefaultCalAction.safeToFloat(number) + DefaultCalAction.safeToFloat(calValue.value)));
        }
    };
    public static final CalAction AVERAGE = new CalAction() { // from class: com.yy.hiidostatis.message.module.sessionreport.DefaultCalAction.2
        @Override // com.yy.hiidostatis.message.module.sessionreport.CalAction
        public CalValue cal(Number number, CalValue calValue) {
            return calValue.updateValue(Double.valueOf((DefaultCalAction.safeToFloat(number) + DefaultCalAction.safeToFloat(calValue.value)) / (calValue.times.get() + 1)));
        }
    };
    public static final CalAction MAX = new CalAction() { // from class: com.yy.hiidostatis.message.module.sessionreport.DefaultCalAction.3
        @Override // com.yy.hiidostatis.message.module.sessionreport.CalAction
        public CalValue cal(Number number, CalValue calValue) {
            if (calValue.value == null) {
                return calValue.updateValue(number);
            }
            if (DefaultCalAction.isInt(number) && DefaultCalAction.isInt(calValue.value)) {
                return calValue.updateValue(Long.valueOf(Math.max(DefaultCalAction.safeToInt(number), DefaultCalAction.safeToInt(calValue.value))));
            }
            return calValue.updateValue(Double.valueOf(Math.max(DefaultCalAction.safeToFloat(number), DefaultCalAction.safeToFloat(calValue.value))));
        }
    };
    public static final CalAction MIN = new CalAction() { // from class: com.yy.hiidostatis.message.module.sessionreport.DefaultCalAction.4
        @Override // com.yy.hiidostatis.message.module.sessionreport.CalAction
        public CalValue cal(Number number, CalValue calValue) {
            if (calValue.value == null) {
                return calValue.updateValue(number);
            }
            if (DefaultCalAction.isInt(number) && DefaultCalAction.isInt(calValue.value)) {
                return calValue.updateValue(Long.valueOf(Math.min(DefaultCalAction.safeToInt(number), DefaultCalAction.safeToInt(calValue.value))));
            }
            return calValue.updateValue(Double.valueOf(Math.min(DefaultCalAction.safeToFloat(number), DefaultCalAction.safeToFloat(calValue.value))));
        }
    };
    public static final CalAction TEMP_STORE = new CalAction() { // from class: com.yy.hiidostatis.message.module.sessionreport.DefaultCalAction.5
        @Override // com.yy.hiidostatis.message.module.sessionreport.CalAction
        public CalValue cal(Number number, CalValue calValue) {
            return calValue.updateTempStorage(number);
        }
    };
    public static final CalAction SUM_DEVIATION = new CalAction() { // from class: com.yy.hiidostatis.message.module.sessionreport.DefaultCalAction.6
        @Override // com.yy.hiidostatis.message.module.sessionreport.CalAction
        public CalValue cal(Number number, CalValue calValue) {
            if (DefaultCalAction.isInt(number) && DefaultCalAction.isInt((Number) calValue.tempStorage)) {
                return calValue.updateValue(Long.valueOf((DefaultCalAction.safeToInt(calValue.value) + DefaultCalAction.safeToInt(number)) - DefaultCalAction.safeToInt((Number) calValue.tempStorage)));
            }
            return calValue.updateValue(Double.valueOf((DefaultCalAction.safeToInt(calValue.value) + DefaultCalAction.safeToFloat(number)) - DefaultCalAction.safeToFloat((Number) calValue.tempStorage)));
        }
    };
    public static final CalAction SUM_DEVIATION_AND_UPDATE_TEMP = new CalAction() { // from class: com.yy.hiidostatis.message.module.sessionreport.DefaultCalAction.7
        @Override // com.yy.hiidostatis.message.module.sessionreport.CalAction
        public CalValue cal(Number number, CalValue calValue) {
            if (DefaultCalAction.isInt(number) && DefaultCalAction.isInt((Number) calValue.tempStorage)) {
                return calValue.updateValue(Long.valueOf((DefaultCalAction.safeToInt(calValue.value) + DefaultCalAction.safeToInt(number)) - DefaultCalAction.safeToInt((Number) calValue.tempStorage))).updateTempStorage(number);
            }
            return calValue.updateValue(Double.valueOf((DefaultCalAction.safeToInt(calValue.value) + DefaultCalAction.safeToFloat(number)) - DefaultCalAction.safeToFloat((Number) calValue.tempStorage))).updateTempStorage(number);
        }
    };

    public static boolean isInt(Number number) {
        if (number != null && !(number instanceof Long) && !(number instanceof Integer)) {
            return false;
        }
        return true;
    }

    public static double safeToFloat(Number number) {
        if (number == null) {
            return 0.0d;
        }
        return number.doubleValue();
    }

    public static long safeToInt(Number number) {
        if (number == null) {
            return 0L;
        }
        return number.longValue();
    }
}
