package com.win.opensdk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.http.Headers;
import android.os.Build;
import android.provider.CalendarContract;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.kwad.sdk.collector.AppStatusRules;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private String f13754a;

    /* renamed from: b  reason: collision with root package name */
    private String f13755b;
    private String c;

    /* renamed from: case  reason: not valid java name */
    private String f64case;
    private String d;
    private String e;
    private String f;
    private String g;
    private String java;
    private p qjU;
    public static boolean qjq = false;
    private static SimpleDateFormat qjV = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US);
    private static SimpleDateFormat qjW = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZZZZZ", Locale.US);

    public static o abS(String str) {
        o oVar = new o();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("id")) {
                oVar.java = jSONObject.getString("id");
            }
            if (!jSONObject.isNull("description")) {
                oVar.f64case = jSONObject.getString("description");
            }
            if (!jSONObject.isNull(Headers.LOCATION)) {
                oVar.f13754a = jSONObject.getString(Headers.LOCATION);
            }
            if (!jSONObject.isNull("summary")) {
                oVar.f13755b = jSONObject.getString("summary");
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
                oVar.qjU = new p();
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("recurrence");
                    if (!jSONObject2.isNull("frequency")) {
                        oVar.qjU.f66java = jSONObject2.getString("frequency");
                    }
                    if (!jSONObject2.isNull("interval")) {
                        oVar.qjU.java = jSONObject2.getInt("interval");
                    }
                    if (!jSONObject2.isNull("expires")) {
                        oVar.qjU.f65case = jSONObject2.getString("expires");
                    }
                    if (!jSONObject2.isNull("exceptionDates")) {
                        JSONArray jSONArray = jSONObject2.getJSONArray("exceptionDates");
                        int length = jSONArray.length();
                        oVar.qjU.qjX = new String[length];
                        for (int i = 0; i < length; i++) {
                            oVar.qjU.qjX[i] = jSONArray.getString(i);
                        }
                    }
                    if (!jSONObject2.isNull("daysInWeek")) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("daysInWeek");
                        int length2 = jSONArray2.length();
                        oVar.qjU.f67java = new int[length2];
                        for (int i2 = 0; i2 < length2; i2++) {
                            oVar.qjU.f67java[i2] = jSONArray2.getInt(i2);
                        }
                    }
                    if (!jSONObject2.isNull("daysInMonth")) {
                        JSONArray jSONArray3 = jSONObject2.getJSONArray("daysInMonth");
                        int length3 = jSONArray3.length();
                        oVar.qjU.qjY = new int[length3];
                        for (int i3 = 0; i3 < length3; i3++) {
                            oVar.qjU.qjY[i3] = jSONArray3.getInt(i3);
                        }
                    }
                    if (!jSONObject2.isNull("daysInYear")) {
                        JSONArray jSONArray4 = jSONObject2.getJSONArray("daysInYear");
                        int length4 = jSONArray4.length();
                        oVar.qjU.f13756a = new int[length4];
                        for (int i4 = 0; i4 < length4; i4++) {
                            oVar.qjU.f13756a[i4] = jSONArray4.getInt(i4);
                        }
                    }
                    if (!jSONObject2.isNull("weeksInMonth")) {
                        JSONArray jSONArray5 = jSONObject2.getJSONArray("weeksInMonth");
                        int length5 = jSONArray5.length();
                        oVar.qjU.f13757b = new int[length5];
                        for (int i5 = 0; i5 < length5; i5++) {
                            oVar.qjU.f13757b[i5] = jSONArray5.getInt(i5);
                        }
                    }
                    if (!jSONObject2.isNull("monthsInYear")) {
                        JSONArray jSONArray6 = jSONObject2.getJSONArray("monthsInYear");
                        int length6 = jSONArray6.length();
                        oVar.qjU.c = new int[length6];
                        for (int i6 = 0; i6 < length6; i6++) {
                            oVar.qjU.c[i6] = jSONArray6.getInt(i6);
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
    public final Intent eIZ() {
        Intent type;
        boolean z = !qjq && Build.VERSION.SDK_INT >= 14;
        if (z) {
            type = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        } else {
            type = new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event");
        }
        if (!TextUtils.isEmpty(this.f64case)) {
            if (z) {
                type.putExtra("title", this.f64case);
            } else {
                type.putExtra("title", this.f64case);
            }
        }
        if (!TextUtils.isEmpty(this.f13754a)) {
            if (z) {
                type.putExtra("eventLocation", this.f13754a);
            } else {
                type.putExtra("eventLocation", this.f13754a);
            }
        }
        if (!TextUtils.isEmpty(this.f13755b)) {
            if (z) {
                type.putExtra("description", this.f13755b);
            } else {
                type.putExtra("description", this.f13755b);
            }
        }
        if (!TextUtils.isEmpty(this.c)) {
            long abT = abT(this.c);
            if (abT > 0) {
                if (z) {
                    type.putExtra("beginTime", abT);
                } else {
                    type.putExtra("beginTime", abT);
                }
            }
        }
        if (!TextUtils.isEmpty(this.d)) {
            long abT2 = abT(this.d);
            if (abT2 > 0) {
                if (z) {
                    type.putExtra("endTime", abT2);
                } else {
                    type.putExtra("endTime", abT2);
                }
            }
        }
        if (!TextUtils.isEmpty(this.e) && z) {
            type.putExtra("eventStatus", this.e);
        }
        if (!TextUtils.isEmpty(this.f) && z) {
            type.putExtra("visible", !this.f.equals("opaque"));
        }
        if (!TextUtils.isEmpty(this.g)) {
            long abT3 = abT(this.g);
            if (abT3 < 0) {
                if (z) {
                    type.putExtra("minutes", Math.abs(abT3 / AppStatusRules.DEFAULT_GRANULARITY));
                }
            } else if (!TextUtils.isEmpty(this.c) && z) {
                long abT4 = abT(this.c);
                if (abT4 > 0) {
                    type.putExtra("minutes", Math.abs((abT4 - abT3) / AppStatusRules.DEFAULT_GRANULARITY));
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        if (this.qjU != null) {
            String str = this.qjU.f66java;
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
            if (this.qjU.java > 0) {
                sb.append("INTERVAL=");
                sb.append(this.qjU.java);
                sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            }
            if ("weekly".equals(str) && this.qjU.f67java != null && this.qjU.f67java.length > 0) {
                sb.append("BYDAY=");
                for (int i : this.qjU.f67java) {
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
            if ("monthly".equals(str) && this.qjU.qjY != null && this.qjU.qjY.length > 0) {
                sb.append("BYMONTHDAY=");
                for (int i2 : this.qjU.qjY) {
                    sb.append(i2);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("yearly".equals(str) && this.qjU.f13756a != null && this.qjU.f13756a.length > 0) {
                sb.append("BYYEARDAY=");
                for (int i3 : this.qjU.f13756a) {
                    sb.append(i3);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("yearly".equals(str) && this.qjU.c != null && this.qjU.c.length > 0) {
                sb.append("BYMONTH=");
                for (int i4 : this.qjU.c) {
                    sb.append(i4);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("monthly".equals(str) && this.qjU.f13757b != null && this.qjU.f13757b.length > 0) {
                sb.append("BYWEEKNO=");
                for (int i5 : this.qjU.f13757b) {
                    sb.append(i5);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if (!TextUtils.isEmpty(this.qjU.f65case)) {
                sb.append("UNTIL=");
                sb.append(this.qjU.f65case);
                sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            }
            if (this.qjU.qjX != null && this.qjU.qjX.length > 0) {
                sb.append("EXDATE=");
                for (String str2 : this.qjU.qjX) {
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

    private static long abT(String str) {
        try {
            return qjV.parse(str).getTime();
        } catch (ParseException e) {
            try {
                return qjW.parse(str).getTime();
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
