package com.win.opensdk;

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
/* loaded from: classes14.dex */
public class au {
    public static SimpleDateFormat qkO = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US);
    public static SimpleDateFormat qkP = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZZZZZ", Locale.US);

    /* renamed from: a  reason: collision with root package name */
    public String f8112a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public bb qkQ;

    public static au abZ(String str) {
        au auVar = new au();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("id")) {
                jSONObject.getString("id");
            }
            if (!jSONObject.isNull("description")) {
                auVar.f8112a = jSONObject.getString("description");
            }
            if (!jSONObject.isNull(Headers.LOCATION)) {
                auVar.b = jSONObject.getString(Headers.LOCATION);
            }
            if (!jSONObject.isNull("summary")) {
                auVar.c = jSONObject.getString("summary");
            }
            if (!jSONObject.isNull("start")) {
                auVar.d = jSONObject.getString("start");
            }
            if (!jSONObject.isNull("end")) {
                if (jSONObject.isNull("start")) {
                    auVar.d = jSONObject.getString("end");
                }
                auVar.e = jSONObject.getString("end");
            }
            if (!jSONObject.isNull("status")) {
                auVar.f = jSONObject.getString("status");
            }
            if (!jSONObject.isNull("freebusy")) {
                auVar.g = jSONObject.getString("freebusy");
            }
            if (!jSONObject.isNull(NotificationCompat.CATEGORY_REMINDER)) {
                auVar.h = jSONObject.getString(NotificationCompat.CATEGORY_REMINDER);
            }
            if (!jSONObject.isNull("recurrence")) {
                auVar.qkQ = new bb();
                JSONObject jSONObject2 = jSONObject.getJSONObject("recurrence");
                if (!jSONObject2.isNull("frequency")) {
                    auVar.qkQ.f8116a = jSONObject2.getString("frequency");
                }
                if (!jSONObject2.isNull("interval")) {
                    auVar.qkQ.b = jSONObject2.getInt("interval");
                }
                if (!jSONObject2.isNull("expires")) {
                    auVar.qkQ.c = jSONObject2.getString("expires");
                }
                if (!jSONObject2.isNull("exceptionDates")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("exceptionDates");
                    int length = jSONArray.length();
                    auVar.qkQ.d = new String[length];
                    for (int i = 0; i < length; i++) {
                        auVar.qkQ.d[i] = jSONArray.getString(i);
                    }
                }
                if (!jSONObject2.isNull("daysInWeek")) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("daysInWeek");
                    int length2 = jSONArray2.length();
                    auVar.qkQ.e = new int[length2];
                    for (int i2 = 0; i2 < length2; i2++) {
                        auVar.qkQ.e[i2] = jSONArray2.getInt(i2);
                    }
                }
                if (!jSONObject2.isNull("daysInMonth")) {
                    JSONArray jSONArray3 = jSONObject2.getJSONArray("daysInMonth");
                    int length3 = jSONArray3.length();
                    auVar.qkQ.f = new int[length3];
                    for (int i3 = 0; i3 < length3; i3++) {
                        auVar.qkQ.f[i3] = jSONArray3.getInt(i3);
                    }
                }
                if (!jSONObject2.isNull("daysInYear")) {
                    JSONArray jSONArray4 = jSONObject2.getJSONArray("daysInYear");
                    int length4 = jSONArray4.length();
                    auVar.qkQ.g = new int[length4];
                    for (int i4 = 0; i4 < length4; i4++) {
                        auVar.qkQ.g[i4] = jSONArray4.getInt(i4);
                    }
                }
                if (!jSONObject2.isNull("weeksInMonth")) {
                    JSONArray jSONArray5 = jSONObject2.getJSONArray("weeksInMonth");
                    int length5 = jSONArray5.length();
                    auVar.qkQ.h = new int[length5];
                    for (int i5 = 0; i5 < length5; i5++) {
                        auVar.qkQ.h[i5] = jSONArray5.getInt(i5);
                    }
                }
                if (!jSONObject2.isNull("monthsInYear")) {
                    JSONArray jSONArray6 = jSONObject2.getJSONArray("monthsInYear");
                    int length6 = jSONArray6.length();
                    auVar.qkQ.i = new int[length6];
                    for (int i6 = 0; i6 < length6; i6++) {
                        auVar.qkQ.i[i6] = jSONArray6.getInt(i6);
                    }
                }
            }
        } catch (JSONException e) {
        }
        return auVar;
    }

    public final long a(String str) {
        try {
            return qkO.parse(str).getTime();
        } catch (ParseException e) {
            try {
                return qkP.parse(str).getTime();
            } catch (ParseException e2) {
                try {
                    return Long.parseLong(str);
                } catch (NumberFormatException e3) {
                    return -1L;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0235 A[LOOP:2: B:104:0x0233->B:105:0x0235, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x026c A[LOOP:3: B:114:0x026a->B:115:0x026c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02a3 A[LOOP:4: B:124:0x02a1->B:125:0x02a3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02ee A[LOOP:5: B:135:0x02ec->B:136:0x02ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01fe A[LOOP:1: B:94:0x01fc->B:95:0x01fe, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Intent a() {
        String[] strArr;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        boolean z = Build.VERSION.SDK_INT >= 14;
        Intent data = z ? new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI) : new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event");
        if (!TextUtils.isEmpty(this.f8112a)) {
            data.putExtra("title", this.f8112a);
        }
        if (!TextUtils.isEmpty(this.b)) {
            data.putExtra("eventLocation", this.b);
        }
        if (!TextUtils.isEmpty(this.c)) {
            data.putExtra("description", this.c);
        }
        if (!TextUtils.isEmpty(this.d)) {
            long a2 = a(this.d);
            if (a2 > 0) {
                data.putExtra("beginTime", a2);
            }
        }
        if (!TextUtils.isEmpty(this.e)) {
            long a3 = a(this.e);
            if (a3 > 0) {
                data.putExtra("endTime", a3);
            }
        }
        if (!TextUtils.isEmpty(this.f) && z) {
            data.putExtra("eventStatus", this.f);
        }
        if (!TextUtils.isEmpty(this.g) && z) {
            data.putExtra("visible", !this.g.equals("opaque"));
        }
        if (!TextUtils.isEmpty(this.h)) {
            long a4 = a(this.h);
            if (a4 < 0) {
                if (z) {
                    data.putExtra("minutes", Math.abs(a4 / AppStatusRules.DEFAULT_GRANULARITY));
                }
            } else if (!TextUtils.isEmpty(this.d) && z) {
                long a5 = a(this.d);
                if (a5 > 0) {
                    data.putExtra("minutes", Math.abs((a5 - a4) / AppStatusRules.DEFAULT_GRANULARITY));
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        bb bbVar = this.qkQ;
        if (bbVar != null) {
            String str = bbVar.f8116a;
            if (!TextUtils.isEmpty(str)) {
                if ("daily".equals(str)) {
                    sb.append("FREQ=DAILY;");
                } else if ("weekly".equals(str)) {
                    sb.append("FREQ=WEEKLY;");
                } else if ("monthly".equals(str)) {
                    sb.append("FREQ=MONTHLY;");
                } else if ("yearly".equals(str)) {
                    sb.append("FREQ=YEARLY;");
                }
                if (this.qkQ.b > 0) {
                    sb.append("INTERVAL=");
                    sb.append(this.qkQ.b);
                    sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                }
                if ("weekly".equals(str) && (iArr5 = this.qkQ.e) != null && iArr5.length > 0) {
                    sb.append("BYDAY=");
                    for (int i : this.qkQ.e) {
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
                if ("monthly".equals(str) && (iArr4 = this.qkQ.f) != null && iArr4.length > 0) {
                    sb.append("BYMONTHDAY=");
                    for (int i2 : this.qkQ.f) {
                        sb.append(i2);
                        sb.append(",");
                    }
                    sb.setCharAt(sb.length() - 1, ';');
                }
                if ("yearly".equals(str) && (iArr3 = this.qkQ.g) != null && iArr3.length > 0) {
                    sb.append("BYYEARDAY=");
                    for (int i3 : this.qkQ.g) {
                        sb.append(i3);
                        sb.append(",");
                    }
                    sb.setCharAt(sb.length() - 1, ';');
                }
                if ("yearly".equals(str) && (iArr2 = this.qkQ.i) != null && iArr2.length > 0) {
                    sb.append("BYMONTH=");
                    for (int i4 : this.qkQ.i) {
                        sb.append(i4);
                        sb.append(",");
                    }
                    sb.setCharAt(sb.length() - 1, ';');
                }
                if ("monthly".equals(str) && (iArr = this.qkQ.h) != null && iArr.length > 0) {
                    sb.append("BYWEEKNO=");
                    for (int i5 : this.qkQ.h) {
                        sb.append(i5);
                        sb.append(",");
                    }
                    sb.setCharAt(sb.length() - 1, ';');
                }
                if (!TextUtils.isEmpty(this.qkQ.c)) {
                    sb.append("UNTIL=");
                    sb.append(this.qkQ.c);
                    sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                }
                strArr = this.qkQ.d;
                if (strArr != null && strArr.length > 0) {
                    sb.append("EXDATE=");
                    for (String str2 : this.qkQ.d) {
                        sb.append(str2);
                        sb.append(",");
                    }
                    sb.setCharAt(sb.length() - 1, ';');
                }
                data.putExtra("rrule", sb.toString());
            }
            str = "";
            if (this.qkQ.b > 0) {
            }
            if ("weekly".equals(str)) {
                sb.append("BYDAY=");
                while (r3 < r6) {
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("monthly".equals(str)) {
                sb.append("BYMONTHDAY=");
                while (r3 < r6) {
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("yearly".equals(str)) {
                sb.append("BYYEARDAY=");
                while (r3 < r6) {
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("yearly".equals(str)) {
                sb.append("BYMONTH=");
                while (r3 < r6) {
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("monthly".equals(str)) {
                sb.append("BYWEEKNO=");
                while (r1 < r5) {
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if (!TextUtils.isEmpty(this.qkQ.c)) {
            }
            strArr = this.qkQ.d;
            if (strArr != null) {
                sb.append("EXDATE=");
                while (r1 < r5) {
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            data.putExtra("rrule", sb.toString());
        }
        return data;
    }
}
