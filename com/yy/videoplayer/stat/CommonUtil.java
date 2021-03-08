package com.yy.videoplayer.stat;

import com.baidu.webkit.internal.ETAG;
import com.yy.videoplayer.utils.YMFLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class CommonUtil {
    public static int calcListMean(List<Integer> list) {
        int i;
        int i2 = 0;
        if (list != null && list.size() > 0) {
            Iterator<Integer> it = list.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = it.next().intValue() + i;
            }
            i2 = i;
        }
        return i2 / list.size();
    }

    public static int calcListMax(List<Integer> list) {
        int i = 0;
        if (list != null && list.size() > 0) {
            int intValue = list.get(0).intValue();
            Iterator<Integer> it = list.iterator();
            while (true) {
                i = intValue;
                if (!it.hasNext()) {
                    break;
                }
                intValue = it.next().intValue();
                if (i > intValue) {
                    intValue = i;
                }
            }
        }
        return i;
    }

    public static int calcListMin(List<Integer> list) {
        int i = 0;
        if (list != null && list.size() > 0) {
            int intValue = list.get(0).intValue();
            Iterator<Integer> it = list.iterator();
            while (true) {
                i = intValue;
                if (!it.hasNext()) {
                    break;
                }
                intValue = it.next().intValue();
                if (i < intValue) {
                    intValue = i;
                }
            }
        }
        return i;
    }

    public static int calcListSum(List<Integer> list) {
        int i = 0;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        Iterator<Integer> it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().intValue() + i2;
        }
    }

    public static String getParamsOrderByKey(Map<String, Object> map) {
        String str = "";
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.addAll(map.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            String str3 = (String) it.next();
            str = str2 + ETAG.ITEM_SEPARATOR + str3 + "=" + (map.get(str3) == null ? 0 : map.get(str3));
        }
    }

    public static String toURLEncoded(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        try {
            return URLEncoder.encode(new String(str.getBytes(), "UTF-8"), "UTF-8");
        } catch (Exception e) {
            YMFLog.error((Object) null, "[Util    ]", "toURLEncoded exception:" + e.toString());
            return "";
        }
    }

    public static int wrapperHiidoDecodeId(int i) {
        switch (i) {
            case 0:
                return 3;
            case 1:
                return 4;
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return 0;
        }
    }

    /* loaded from: classes6.dex */
    public static class Size {
        private int height;
        private int width;

        public Size(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public Size() {
            this.width = 0;
            this.height = 0;
        }

        public int getWidth() {
            return this.width;
        }

        public void setWidth(int i) {
            this.width = i;
        }

        public int getHeight() {
            return this.height;
        }

        public void setHeight(int i) {
            this.height = i;
        }
    }
}
