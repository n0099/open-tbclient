package com.yy.hiidostatis.message.module.sessionreport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes7.dex */
public class EventValue {
    public CalAction calAction;
    public Map<String, String> dimens;
    public Map<String, String> extra;
    public String key;
    public Number value;

    public EventValue(CalAction calAction, String str, Number number) {
        this.calAction = calAction;
        this.key = str;
        this.value = number;
    }

    public String dimIdentification() {
        Map<String, String> map = this.dimens;
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList(this.dimens.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            sb.append(str);
            sb.append("=");
            sb.append(this.dimens.get(str));
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
