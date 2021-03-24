package com.win.opensdk;

import android.content.Intent;
import android.os.Build;
import android.provider.CalendarContract;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class P0 {
    public static SimpleDateFormat j = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US);
    public static SimpleDateFormat k = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZZZZZ", Locale.US);

    /* renamed from: a  reason: collision with root package name */
    public String f39735a;

    /* renamed from: b  reason: collision with root package name */
    public String f39736b;

    /* renamed from: c  reason: collision with root package name */
    public String f39737c;

    /* renamed from: d  reason: collision with root package name */
    public String f39738d;

    /* renamed from: e  reason: collision with root package name */
    public String f39739e;

    /* renamed from: f  reason: collision with root package name */
    public String f39740f;

    /* renamed from: g  reason: collision with root package name */
    public String f39741g;

    /* renamed from: h  reason: collision with root package name */
    public String f39742h;
    public Q0 i;

    public static P0 b(String str) {
        P0 p0 = new P0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("id")) {
                jSONObject.getString("id");
            }
            if (!jSONObject.isNull("description")) {
                p0.f39735a = jSONObject.getString("description");
            }
            if (!jSONObject.isNull("location")) {
                p0.f39736b = jSONObject.getString("location");
            }
            if (!jSONObject.isNull("summary")) {
                p0.f39737c = jSONObject.getString("summary");
            }
            if (!jSONObject.isNull(IntentConfig.START)) {
                p0.f39738d = jSONObject.getString(IntentConfig.START);
            }
            if (!jSONObject.isNull(ProgressInfo.JSON_KEY_END)) {
                if (jSONObject.isNull(IntentConfig.START)) {
                    p0.f39738d = jSONObject.getString(ProgressInfo.JSON_KEY_END);
                }
                p0.f39739e = jSONObject.getString(ProgressInfo.JSON_KEY_END);
            }
            if (!jSONObject.isNull("status")) {
                p0.f39740f = jSONObject.getString("status");
            }
            if (!jSONObject.isNull("freebusy")) {
                p0.f39741g = jSONObject.getString("freebusy");
            }
            if (!jSONObject.isNull(NotificationCompat.CATEGORY_REMINDER)) {
                p0.f39742h = jSONObject.getString(NotificationCompat.CATEGORY_REMINDER);
            }
            if (!jSONObject.isNull("recurrence")) {
                p0.i = new Q0();
                JSONObject jSONObject2 = jSONObject.getJSONObject("recurrence");
                if (!jSONObject2.isNull("frequency")) {
                    p0.i.f39773a = jSONObject2.getString("frequency");
                }
                if (!jSONObject2.isNull("interval")) {
                    p0.i.f39774b = jSONObject2.getInt("interval");
                }
                if (!jSONObject2.isNull("expires")) {
                    p0.i.f39775c = jSONObject2.getString("expires");
                }
                if (!jSONObject2.isNull("exceptionDates")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("exceptionDates");
                    int length = jSONArray.length();
                    p0.i.f39776d = new String[length];
                    for (int i = 0; i < length; i++) {
                        p0.i.f39776d[i] = jSONArray.getString(i);
                    }
                }
                if (!jSONObject2.isNull("daysInWeek")) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("daysInWeek");
                    int length2 = jSONArray2.length();
                    p0.i.f39777e = new int[length2];
                    for (int i2 = 0; i2 < length2; i2++) {
                        p0.i.f39777e[i2] = jSONArray2.getInt(i2);
                    }
                }
                if (!jSONObject2.isNull("daysInMonth")) {
                    JSONArray jSONArray3 = jSONObject2.getJSONArray("daysInMonth");
                    int length3 = jSONArray3.length();
                    p0.i.f39778f = new int[length3];
                    for (int i3 = 0; i3 < length3; i3++) {
                        p0.i.f39778f[i3] = jSONArray3.getInt(i3);
                    }
                }
                if (!jSONObject2.isNull("daysInYear")) {
                    JSONArray jSONArray4 = jSONObject2.getJSONArray("daysInYear");
                    int length4 = jSONArray4.length();
                    p0.i.f39779g = new int[length4];
                    for (int i4 = 0; i4 < length4; i4++) {
                        p0.i.f39779g[i4] = jSONArray4.getInt(i4);
                    }
                }
                if (!jSONObject2.isNull("weeksInMonth")) {
                    JSONArray jSONArray5 = jSONObject2.getJSONArray("weeksInMonth");
                    int length5 = jSONArray5.length();
                    p0.i.f39780h = new int[length5];
                    for (int i5 = 0; i5 < length5; i5++) {
                        p0.i.f39780h[i5] = jSONArray5.getInt(i5);
                    }
                }
                if (!jSONObject2.isNull("monthsInYear")) {
                    JSONArray jSONArray6 = jSONObject2.getJSONArray("monthsInYear");
                    int length6 = jSONArray6.length();
                    p0.i.i = new int[length6];
                    for (int i6 = 0; i6 < length6; i6++) {
                        p0.i.i[i6] = jSONArray6.getInt(i6);
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return p0;
    }

    public final long a(String str) {
        try {
            try {
                try {
                    return j.parse(str).getTime();
                } catch (ParseException unused) {
                    return Long.parseLong(str);
                }
            } catch (ParseException unused2) {
                return k.parse(str).getTime();
            }
        } catch (NumberFormatException unused3) {
            return -1L;
        }
    }

    public Intent a() {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        String str;
        String str2;
        boolean z = Build.VERSION.SDK_INT >= 14;
        Intent data = z ? new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI) : new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event");
        if (!TextUtils.isEmpty(this.f39735a)) {
            data.putExtra("title", this.f39735a);
        }
        if (!TextUtils.isEmpty(this.f39736b)) {
            data.putExtra("eventLocation", this.f39736b);
        }
        if (!TextUtils.isEmpty(this.f39737c)) {
            data.putExtra("description", this.f39737c);
        }
        if (!TextUtils.isEmpty(this.f39738d)) {
            long a2 = a(this.f39738d);
            if (a2 > 0) {
                data.putExtra("beginTime", a2);
            }
        }
        if (!TextUtils.isEmpty(this.f39739e)) {
            long a3 = a(this.f39739e);
            if (a3 > 0) {
                data.putExtra("endTime", a3);
            }
        }
        if (!TextUtils.isEmpty(this.f39740f) && z) {
            data.putExtra("eventStatus", this.f39740f);
        }
        if (!TextUtils.isEmpty(this.f39741g) && z) {
            data.putExtra("visible", !this.f39741g.equals("opaque"));
        }
        if (!TextUtils.isEmpty(this.f39742h)) {
            long a4 = a(this.f39742h);
            if (a4 < 0) {
                if (z) {
                    data.putExtra("minutes", Math.abs(a4 / 60000));
                }
            } else if (!TextUtils.isEmpty(this.f39738d) && z) {
                long a5 = a(this.f39738d);
                if (a5 > 0) {
                    data.putExtra("minutes", Math.abs((a5 - a4) / 60000));
                }
            }
        }
        String str3 = "";
        StringBuilder sb = new StringBuilder("");
        Q0 q0 = this.i;
        if (q0 != null) {
            String str4 = q0.f39773a;
            if (!TextUtils.isEmpty(str4)) {
                if ("daily".equals(str4)) {
                    str2 = "FREQ=DAILY;";
                } else if ("weekly".equals(str4)) {
                    str2 = "FREQ=WEEKLY;";
                } else if ("monthly".equals(str4)) {
                    str2 = "FREQ=MONTHLY;";
                } else if ("yearly".equals(str4)) {
                    str2 = "FREQ=YEARLY;";
                }
                sb.append(str2);
                str3 = str4;
            }
            if (this.i.f39774b > 0) {
                sb.append("INTERVAL=");
                sb.append(this.i.f39774b);
                sb.append(";");
            }
            if ("weekly".equals(str3) && (iArr5 = this.i.f39777e) != null && iArr5.length > 0) {
                sb.append("BYDAY=");
                for (int i : this.i.f39777e) {
                    switch (i) {
                        case 0:
                            str = "SU,";
                            break;
                        case 1:
                            str = "MO,";
                            break;
                        case 2:
                            str = "TU,";
                            break;
                        case 3:
                            str = "WE,";
                            break;
                        case 4:
                            str = "TH,";
                            break;
                        case 5:
                            str = "FR,";
                            break;
                        case 6:
                            str = "SA,";
                            break;
                        default:
                    }
                    sb.append(str);
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("monthly".equals(str3) && (iArr4 = this.i.f39778f) != null && iArr4.length > 0) {
                sb.append("BYMONTHDAY=");
                for (int i2 : this.i.f39778f) {
                    sb.append(i2);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("yearly".equals(str3) && (iArr3 = this.i.f39779g) != null && iArr3.length > 0) {
                sb.append("BYYEARDAY=");
                for (int i3 : this.i.f39779g) {
                    sb.append(i3);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("yearly".equals(str3) && (iArr2 = this.i.i) != null && iArr2.length > 0) {
                sb.append("BYMONTH=");
                for (int i4 : this.i.i) {
                    sb.append(i4);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("monthly".equals(str3) && (iArr = this.i.f39780h) != null && iArr.length > 0) {
                sb.append("BYWEEKNO=");
                for (int i5 : this.i.f39780h) {
                    sb.append(i5);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if (!TextUtils.isEmpty(this.i.f39775c)) {
                sb.append("UNTIL=");
                sb.append(this.i.f39775c);
                sb.append(";");
            }
            String[] strArr = this.i.f39776d;
            if (strArr != null && strArr.length > 0) {
                sb.append("EXDATE=");
                for (String str5 : this.i.f39776d) {
                    sb.append(str5);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            data.putExtra("rrule", sb.toString());
        }
        return data;
    }
}
