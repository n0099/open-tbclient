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
    public static boolean qiQ = false;
    private static SimpleDateFormat qjv = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US);
    private static SimpleDateFormat qjw = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZZZZZ", Locale.US);

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
    private p qju;

    public static o abG(String str) {
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
                oVar.qju = new p();
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("recurrence");
                    if (!jSONObject2.isNull("frequency")) {
                        oVar.qju.f66java = jSONObject2.getString("frequency");
                    }
                    if (!jSONObject2.isNull("interval")) {
                        oVar.qju.java = jSONObject2.getInt("interval");
                    }
                    if (!jSONObject2.isNull("expires")) {
                        oVar.qju.f65case = jSONObject2.getString("expires");
                    }
                    if (!jSONObject2.isNull("exceptionDates")) {
                        JSONArray jSONArray = jSONObject2.getJSONArray("exceptionDates");
                        int length = jSONArray.length();
                        oVar.qju.qjx = new String[length];
                        for (int i = 0; i < length; i++) {
                            oVar.qju.qjx[i] = jSONArray.getString(i);
                        }
                    }
                    if (!jSONObject2.isNull("daysInWeek")) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("daysInWeek");
                        int length2 = jSONArray2.length();
                        oVar.qju.f67java = new int[length2];
                        for (int i2 = 0; i2 < length2; i2++) {
                            oVar.qju.f67java[i2] = jSONArray2.getInt(i2);
                        }
                    }
                    if (!jSONObject2.isNull("daysInMonth")) {
                        JSONArray jSONArray3 = jSONObject2.getJSONArray("daysInMonth");
                        int length3 = jSONArray3.length();
                        oVar.qju.qjy = new int[length3];
                        for (int i3 = 0; i3 < length3; i3++) {
                            oVar.qju.qjy[i3] = jSONArray3.getInt(i3);
                        }
                    }
                    if (!jSONObject2.isNull("daysInYear")) {
                        JSONArray jSONArray4 = jSONObject2.getJSONArray("daysInYear");
                        int length4 = jSONArray4.length();
                        oVar.qju.f13756a = new int[length4];
                        for (int i4 = 0; i4 < length4; i4++) {
                            oVar.qju.f13756a[i4] = jSONArray4.getInt(i4);
                        }
                    }
                    if (!jSONObject2.isNull("weeksInMonth")) {
                        JSONArray jSONArray5 = jSONObject2.getJSONArray("weeksInMonth");
                        int length5 = jSONArray5.length();
                        oVar.qju.f13757b = new int[length5];
                        for (int i5 = 0; i5 < length5; i5++) {
                            oVar.qju.f13757b[i5] = jSONArray5.getInt(i5);
                        }
                    }
                    if (!jSONObject2.isNull("monthsInYear")) {
                        JSONArray jSONArray6 = jSONObject2.getJSONArray("monthsInYear");
                        int length6 = jSONArray6.length();
                        oVar.qju.c = new int[length6];
                        for (int i6 = 0; i6 < length6; i6++) {
                            oVar.qju.c[i6] = jSONArray6.getInt(i6);
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
    public final Intent eIR() {
        Intent type;
        boolean z = !qiQ && Build.VERSION.SDK_INT >= 14;
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
            long abH = abH(this.c);
            if (abH > 0) {
                if (z) {
                    type.putExtra("beginTime", abH);
                } else {
                    type.putExtra("beginTime", abH);
                }
            }
        }
        if (!TextUtils.isEmpty(this.d)) {
            long abH2 = abH(this.d);
            if (abH2 > 0) {
                if (z) {
                    type.putExtra("endTime", abH2);
                } else {
                    type.putExtra("endTime", abH2);
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
            long abH3 = abH(this.g);
            if (abH3 < 0) {
                if (z) {
                    type.putExtra("minutes", Math.abs(abH3 / AppStatusRules.DEFAULT_GRANULARITY));
                }
            } else if (!TextUtils.isEmpty(this.c) && z) {
                long abH4 = abH(this.c);
                if (abH4 > 0) {
                    type.putExtra("minutes", Math.abs((abH4 - abH3) / AppStatusRules.DEFAULT_GRANULARITY));
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        if (this.qju != null) {
            String str = this.qju.f66java;
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
            if (this.qju.java > 0) {
                sb.append("INTERVAL=");
                sb.append(this.qju.java);
                sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            }
            if ("weekly".equals(str) && this.qju.f67java != null && this.qju.f67java.length > 0) {
                sb.append("BYDAY=");
                for (int i : this.qju.f67java) {
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
            if ("monthly".equals(str) && this.qju.qjy != null && this.qju.qjy.length > 0) {
                sb.append("BYMONTHDAY=");
                for (int i2 : this.qju.qjy) {
                    sb.append(i2);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("yearly".equals(str) && this.qju.f13756a != null && this.qju.f13756a.length > 0) {
                sb.append("BYYEARDAY=");
                for (int i3 : this.qju.f13756a) {
                    sb.append(i3);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("yearly".equals(str) && this.qju.c != null && this.qju.c.length > 0) {
                sb.append("BYMONTH=");
                for (int i4 : this.qju.c) {
                    sb.append(i4);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("monthly".equals(str) && this.qju.f13757b != null && this.qju.f13757b.length > 0) {
                sb.append("BYWEEKNO=");
                for (int i5 : this.qju.f13757b) {
                    sb.append(i5);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if (!TextUtils.isEmpty(this.qju.f65case)) {
                sb.append("UNTIL=");
                sb.append(this.qju.f65case);
                sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            }
            if (this.qju.qjx != null && this.qju.qjx.length > 0) {
                sb.append("EXDATE=");
                for (String str2 : this.qju.qjx) {
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

    private static long abH(String str) {
        try {
            return qjv.parse(str).getTime();
        } catch (ParseException e) {
            try {
                return qjw.parse(str).getTime();
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
