package com.win.opensdk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.provider.CalendarContract;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.kwad.sdk.collector.AppStatusRules;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private String f14052a;

    /* renamed from: b  reason: collision with root package name */
    private String f14053b;
    private String c;

    /* renamed from: case  reason: not valid java name */
    private String f65case;
    private String d;
    private String e;
    private String f;
    private String g;
    private String java;
    private p qdQ;
    public static boolean qdm = false;
    private static SimpleDateFormat qdR = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US);
    private static SimpleDateFormat qdS = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZZZZZ", Locale.US);

    public static o abM(String str) {
        o oVar = new o();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("id")) {
                oVar.java = jSONObject.getString("id");
            }
            if (!jSONObject.isNull("description")) {
                oVar.f65case = jSONObject.getString("description");
            }
            if (!jSONObject.isNull("location")) {
                oVar.f14052a = jSONObject.getString("location");
            }
            if (!jSONObject.isNull("summary")) {
                oVar.f14053b = jSONObject.getString("summary");
            }
            if (!jSONObject.isNull("start")) {
                oVar.c = jSONObject.getString("start");
            }
            if (!jSONObject.isNull("end")) {
                if (jSONObject.isNull("start")) {
                    oVar.c = jSONObject.getString("end");
                }
                oVar.d = jSONObject.getString("end");
            }
            if (!jSONObject.isNull("status")) {
                oVar.e = jSONObject.getString("status");
            }
            if (!jSONObject.isNull("freebusy")) {
                oVar.f = jSONObject.getString("freebusy");
            }
            if (!jSONObject.isNull(NotificationCompat.CATEGORY_REMINDER)) {
                oVar.g = jSONObject.getString(NotificationCompat.CATEGORY_REMINDER);
            }
            if (!jSONObject.isNull("recurrence")) {
                oVar.qdQ = new p();
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("recurrence");
                    if (!jSONObject2.isNull("frequency")) {
                        oVar.qdQ.f67java = jSONObject2.getString("frequency");
                    }
                    if (!jSONObject2.isNull("interval")) {
                        oVar.qdQ.java = jSONObject2.getInt("interval");
                    }
                    if (!jSONObject2.isNull("expires")) {
                        oVar.qdQ.f66case = jSONObject2.getString("expires");
                    }
                    if (!jSONObject2.isNull("exceptionDates")) {
                        JSONArray jSONArray = jSONObject2.getJSONArray("exceptionDates");
                        int length = jSONArray.length();
                        oVar.qdQ.qdT = new String[length];
                        for (int i = 0; i < length; i++) {
                            oVar.qdQ.qdT[i] = jSONArray.getString(i);
                        }
                    }
                    if (!jSONObject2.isNull("daysInWeek")) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("daysInWeek");
                        int length2 = jSONArray2.length();
                        oVar.qdQ.f68java = new int[length2];
                        for (int i2 = 0; i2 < length2; i2++) {
                            oVar.qdQ.f68java[i2] = jSONArray2.getInt(i2);
                        }
                    }
                    if (!jSONObject2.isNull("daysInMonth")) {
                        JSONArray jSONArray3 = jSONObject2.getJSONArray("daysInMonth");
                        int length3 = jSONArray3.length();
                        oVar.qdQ.qdU = new int[length3];
                        for (int i3 = 0; i3 < length3; i3++) {
                            oVar.qdQ.qdU[i3] = jSONArray3.getInt(i3);
                        }
                    }
                    if (!jSONObject2.isNull("daysInYear")) {
                        JSONArray jSONArray4 = jSONObject2.getJSONArray("daysInYear");
                        int length4 = jSONArray4.length();
                        oVar.qdQ.f14054a = new int[length4];
                        for (int i4 = 0; i4 < length4; i4++) {
                            oVar.qdQ.f14054a[i4] = jSONArray4.getInt(i4);
                        }
                    }
                    if (!jSONObject2.isNull("weeksInMonth")) {
                        JSONArray jSONArray5 = jSONObject2.getJSONArray("weeksInMonth");
                        int length5 = jSONArray5.length();
                        oVar.qdQ.f14055b = new int[length5];
                        for (int i5 = 0; i5 < length5; i5++) {
                            oVar.qdQ.f14055b[i5] = jSONArray5.getInt(i5);
                        }
                    }
                    if (!jSONObject2.isNull("monthsInYear")) {
                        JSONArray jSONArray6 = jSONObject2.getJSONArray("monthsInYear");
                        int length6 = jSONArray6.length();
                        oVar.qdQ.c = new int[length6];
                        for (int i6 = 0; i6 < length6; i6++) {
                            oVar.qdQ.c[i6] = jSONArray6.getInt(i6);
                        }
                    }
                } catch (JSONException e) {
                }
            }
        } catch (JSONException e2) {
        }
        return oVar;
    }

    private o() {
    }

    @SuppressLint({"NewApi", "InlinedApi"})
    public final Intent eKr() {
        Intent type;
        boolean z = !qdm && Build.VERSION.SDK_INT >= 14;
        if (z) {
            type = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        } else {
            type = new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event");
        }
        if (!TextUtils.isEmpty(this.f65case)) {
            if (z) {
                type.putExtra("title", this.f65case);
            } else {
                type.putExtra("title", this.f65case);
            }
        }
        if (!TextUtils.isEmpty(this.f14052a)) {
            if (z) {
                type.putExtra("eventLocation", this.f14052a);
            } else {
                type.putExtra("eventLocation", this.f14052a);
            }
        }
        if (!TextUtils.isEmpty(this.f14053b)) {
            if (z) {
                type.putExtra("description", this.f14053b);
            } else {
                type.putExtra("description", this.f14053b);
            }
        }
        if (!TextUtils.isEmpty(this.c)) {
            long abN = abN(this.c);
            if (abN > 0) {
                if (z) {
                    type.putExtra("beginTime", abN);
                } else {
                    type.putExtra("beginTime", abN);
                }
            }
        }
        if (!TextUtils.isEmpty(this.d)) {
            long abN2 = abN(this.d);
            if (abN2 > 0) {
                if (z) {
                    type.putExtra("endTime", abN2);
                } else {
                    type.putExtra("endTime", abN2);
                }
            }
        }
        if (!TextUtils.isEmpty(this.e) && z) {
            type.putExtra("eventStatus", this.e);
        }
        if (!TextUtils.isEmpty(this.f) && z) {
            type.putExtra(MapBundleKey.MapObjKey.OBJ_SL_VISI, !this.f.equals("opaque"));
        }
        if (!TextUtils.isEmpty(this.g)) {
            long abN3 = abN(this.g);
            if (abN3 < 0) {
                if (z) {
                    type.putExtra("minutes", Math.abs(abN3 / AppStatusRules.DEFAULT_GRANULARITY));
                }
            } else if (!TextUtils.isEmpty(this.c) && z) {
                long abN4 = abN(this.c);
                if (abN4 > 0) {
                    type.putExtra("minutes", Math.abs((abN4 - abN3) / AppStatusRules.DEFAULT_GRANULARITY));
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        if (this.qdQ != null) {
            String str = this.qdQ.f67java;
            if (!TextUtils.isEmpty(str)) {
                if ("daily".equals(str)) {
                    sb.append("FREQ=DAILY;");
                } else if ("weekly".equals(str)) {
                    sb.append("FREQ=WEEKLY;");
                } else if ("monthly".equals(str)) {
                    sb.append("FREQ=MONTHLY;");
                } else if ("yearly".equals(str)) {
                    sb.append("FREQ=YEARLY;");
                } else {
                    str = "";
                }
            } else {
                str = "";
            }
            if (this.qdQ.java > 0) {
                sb.append("INTERVAL=");
                sb.append(this.qdQ.java);
                sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            }
            if ("weekly".equals(str) && this.qdQ.f68java != null && this.qdQ.f68java.length > 0) {
                sb.append("BYDAY=");
                for (int i : this.qdQ.f68java) {
                    switch (i) {
                        case 0:
                            sb.append("SU,");
                            break;
                        case 1:
                            sb.append("MO,");
                            break;
                        case 2:
                            sb.append("TU,");
                            break;
                        case 3:
                            sb.append("WE,");
                            break;
                        case 4:
                            sb.append("TH,");
                            break;
                        case 5:
                            sb.append("FR,");
                            break;
                        case 6:
                            sb.append("SA,");
                            break;
                    }
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("monthly".equals(str) && this.qdQ.qdU != null && this.qdQ.qdU.length > 0) {
                sb.append("BYMONTHDAY=");
                for (int i2 : this.qdQ.qdU) {
                    sb.append(i2);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("yearly".equals(str) && this.qdQ.f14054a != null && this.qdQ.f14054a.length > 0) {
                sb.append("BYYEARDAY=");
                for (int i3 : this.qdQ.f14054a) {
                    sb.append(i3);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("yearly".equals(str) && this.qdQ.c != null && this.qdQ.c.length > 0) {
                sb.append("BYMONTH=");
                for (int i4 : this.qdQ.c) {
                    sb.append(i4);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("monthly".equals(str) && this.qdQ.f14055b != null && this.qdQ.f14055b.length > 0) {
                sb.append("BYWEEKNO=");
                for (int i5 : this.qdQ.f14055b) {
                    sb.append(i5);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if (!TextUtils.isEmpty(this.qdQ.f66case)) {
                sb.append("UNTIL=");
                sb.append(this.qdQ.f66case);
                sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            }
            if (this.qdQ.qdT != null && this.qdQ.qdT.length > 0) {
                sb.append("EXDATE=");
                for (String str2 : this.qdQ.qdT) {
                    sb.append(str2);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if (z) {
                type.putExtra("rrule", sb.toString());
            } else {
                type.putExtra("rrule", sb.toString());
            }
        }
        return type;
    }

    private static long abN(String str) {
        try {
            return qdR.parse(str).getTime();
        } catch (ParseException e) {
            try {
                return qdS.parse(str).getTime();
            } catch (ParseException e2) {
                try {
                    return Long.parseLong(str);
                } catch (NumberFormatException e3) {
                    return -1L;
                }
            }
        }
    }
}
