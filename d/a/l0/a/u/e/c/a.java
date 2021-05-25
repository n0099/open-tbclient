package d.a.l0.a.u.e.c;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.tbadk.core.util.TbEnum;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.s1.e;
import d.a.l0.a.s1.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.l0.a.u.c.d {

    /* renamed from: e  reason: collision with root package name */
    public static final String f44854e = SchemeConfig.getSchemeHead() + "://swan/";

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f44855f = {"_id", "account_name", "calendar_displayName"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f44856g = {"_id", "calendar_id", "title", "dtstart", "dtend"};

    /* renamed from: d  reason: collision with root package name */
    public int f44857d;

    /* renamed from: d.a.l0.a.u.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0835a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44858e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f44859f;

        public C0835a(String str, d dVar) {
            this.f44858e = str;
            this.f44859f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                a.this.B(this.f44858e, this.f44859f);
            } else {
                a.this.d(this.f44858e, new d.a.l0.a.u.h.b(iVar.b(), d.a.l0.a.e2.c.d.f(iVar.b())));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44861e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f44862f;

        public b(String str, d dVar) {
            this.f44861e = str;
            this.f44862f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                a.this.B(this.f44861e, this.f44862f);
            } else {
                a.this.d(this.f44861e, new d.a.l0.a.u.h.b(iVar.b(), d.a.l0.a.e2.c.d.f(iVar.b())));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f44864a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44865b;

        public c(d dVar, String str) {
            this.f44864a = dVar;
            this.f44865b = str;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            d dVar = this.f44864a;
            int i2 = dVar.f44874h;
            if (i2 == 0) {
                a.this.v(dVar, this.f44865b);
            } else if (i2 != 1) {
            } else {
                a.this.y(dVar, this.f44865b);
            }
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            a.this.d(this.f44865b, new d.a.l0.a.u.h.b(i2, str));
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public String f44867a;

        /* renamed from: b  reason: collision with root package name */
        public long f44868b;

        /* renamed from: c  reason: collision with root package name */
        public long f44869c;

        /* renamed from: d  reason: collision with root package name */
        public String f44870d;

        /* renamed from: e  reason: collision with root package name */
        public int f44871e;

        /* renamed from: f  reason: collision with root package name */
        public long f44872f = -1;

        /* renamed from: g  reason: collision with root package name */
        public d.a.l0.a.u.h.b f44873g;

        /* renamed from: h  reason: collision with root package name */
        public int f44874h;

        public d(int i2) {
            this.f44874h = i2;
        }

        public boolean a() {
            d.a.l0.a.u.h.b bVar = this.f44873g;
            return bVar != null && bVar.a();
        }
    }

    public a(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
        this.f44857d = -1;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final long A(d dVar) {
        Cursor query = i().getContentResolver().query(CalendarContract.Events.CONTENT_URI, f44856g, "((account_name = ?))", new String[]{"智能小程序"}, null);
        if (query != null) {
            try {
                if (query.getCount() >= 1) {
                    query.moveToFirst();
                    do {
                        long j = query.getLong(query.getColumnIndex("_id"));
                        String string = query.getString(query.getColumnIndex("title"));
                        long j2 = query.getLong(query.getColumnIndex("dtstart"));
                        long j3 = query.getLong(query.getColumnIndex("dtend"));
                        if (TextUtils.equals(dVar.f44867a, string) && j2 == dVar.f44868b && j3 == dVar.f44869c) {
                            if (query != null) {
                                query.close();
                            }
                            return j;
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return -1L;
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        if (query != null) {
            query.close();
        }
        return -1L;
    }

    public final void B(String str, d dVar) {
        e.g(new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"}, 4, i(), new c(dVar, str));
    }

    public final void C(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TbEnum.SystemMessage.KEY_EVENT_ID, j + "");
        } catch (JSONException e2) {
            if (d.a.l0.a.u.c.d.f44812c) {
                e2.printStackTrace();
            }
        }
        d(str, new d.a.l0.a.u.h.b(0, jSONObject));
    }

    public final d D(JSONObject jSONObject, int i2) {
        d dVar = new d(i2);
        if (i2 == 0) {
            String optString = jSONObject.optString("title");
            dVar.f44867a = optString;
            if (TextUtils.isEmpty(optString)) {
                d.a.l0.a.e0.d.b("Api-CalendarApi", "addEventOnCalendar requires a valid title");
                dVar.f44873g = new d.a.l0.a.u.h.b(1001, "addEventOnCalendar requires a valid title");
                return dVar;
            }
            long optLong = jSONObject.optLong("startTime", -1L);
            dVar.f44868b = optLong;
            if (optLong == -1) {
                d.a.l0.a.e0.d.b("Api-CalendarApi", "addEventOnCalendar requires a valid startTime");
                dVar.f44873g = new d.a.l0.a.u.h.b(1001, "addEventOnCalendar requires a valid startTime");
                return dVar;
            }
            long optLong2 = jSONObject.optLong("endTime", -1L);
            dVar.f44869c = optLong2;
            if (optLong2 < dVar.f44868b) {
                d.a.l0.a.e0.d.b("Api-CalendarApi", "addEventOnCalendar requires a valid endTime");
                dVar.f44873g = new d.a.l0.a.u.h.b(1001, "addEventOnCalendar requires a valid endTime");
                return dVar;
            }
            dVar.f44871e = jSONObject.optInt("remindMinutesBefore", 10);
            dVar.f44870d = jSONObject.optString("location");
            String optString2 = jSONObject.optString("url");
            if (!TextUtils.isEmpty(optString2)) {
                if (optString2.startsWith(f44854e)) {
                    dVar.f44867a += " " + optString2;
                } else {
                    dVar.f44873g = new d.a.l0.a.u.h.b(2002, "invalid url");
                    return dVar;
                }
            }
            dVar.f44873g = new d.a.l0.a.u.h.b(0);
        } else if (i2 == 1) {
            long optLong3 = jSONObject.optLong(TbEnum.SystemMessage.KEY_EVENT_ID, -1L);
            dVar.f44872f = optLong3;
            if (optLong3 == -1) {
                d.a.l0.a.e0.d.b("Api-CalendarApi", "deleteEventOnCalendar requires a valid eventId");
                dVar.f44873g = new d.a.l0.a.u.h.b(1001, "deleteEventOnCalendar requires a valid eventId");
            } else {
                dVar.f44873g = new d.a.l0.a.u.h.b(0);
            }
        }
        return dVar;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final int E() {
        Context i2 = i();
        Cursor query = i2.getContentResolver().query(CalendarContract.Calendars.CONTENT_URI, f44855f, "((account_name = ?) AND (calendar_displayName = ?))", new String[]{"智能小程序", "智能小程序"}, null);
        if (query != null) {
            try {
                if (query.getCount() >= 1) {
                    query.moveToFirst();
                    int i3 = query.getInt(query.getColumnIndex("_id"));
                    if (query != null) {
                        query.close();
                    }
                    return i3;
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        int w = w(i2);
        if (query != null) {
            query.close();
        }
        return w;
    }

    public d.a.l0.a.u.h.b u(String str) {
        Object obj;
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-CalendarApi", "start addEventOnCalendar");
        }
        if (l()) {
            d.a.l0.a.e0.d.b("Api-CalendarApi", "addEventOnCalendar does not supported when app is invisible.");
            return new d.a.l0.a.u.h.b(1001, "addEventOnCalendar does not supported when app is invisible.");
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-CalendarApi", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (bVar.a() && (obj = b2.second) != null) {
            JSONObject jSONObject = (JSONObject) obj;
            d D = D(jSONObject, 0);
            if (!D.a()) {
                return D.f44873g;
            }
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.l0.a.u.h.b(1001, "addEventOnCalendar requires cb");
            }
            d.a.l0.a.a2.e.i().T().g(i(), "scope_calendar", new C0835a(optString, D));
            return new d.a.l0.a.u.h.b(0);
        }
        d.a.l0.a.e0.d.b("Api-CalendarApi", "parse fail");
        return bVar;
    }

    public final void v(d dVar, String str) {
        String lastPathSegment;
        long j;
        int z = z();
        if (z == -1) {
            d(str, new d.a.l0.a.u.h.b(2003, "addEventOnCalendar fail , system error"));
            return;
        }
        long A = A(dVar);
        if (A > 0) {
            C(str, A);
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("calendar_id", Integer.valueOf(z));
        contentValues.put("accessLevel", (Integer) 3);
        contentValues.put("eventTimezone", "Asia/Shanghai");
        contentValues.put("eventEndTimezone", "Asia/Shanghai");
        contentValues.put("dtstart", Long.valueOf(dVar.f44868b));
        contentValues.put("dtend", Long.valueOf(dVar.f44869c));
        contentValues.put("title", dVar.f44867a);
        if (!TextUtils.isEmpty(dVar.f44870d)) {
            contentValues.put("eventLocation", dVar.f44870d);
        }
        ContentResolver contentResolver = i().getContentResolver();
        Uri insert = contentResolver.insert(CalendarContract.Events.CONTENT_URI, contentValues);
        if (insert != null && (lastPathSegment = insert.getLastPathSegment()) != null) {
            try {
                j = Long.parseLong(lastPathSegment);
            } catch (NumberFormatException e2) {
                if (d.a.l0.a.u.c.d.f44812c) {
                    e2.printStackTrace();
                }
                j = -1;
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("event_id", Long.valueOf(j));
            contentValues2.put("minutes", Integer.valueOf(dVar.f44871e));
            contentValues2.put("method", (Integer) 1);
            Uri insert2 = contentResolver.insert(CalendarContract.Reminders.CONTENT_URI, contentValues2);
            if (insert2 != null && ContentUris.parseId(insert2) != 0) {
                C(str, j);
                return;
            } else {
                d(str, new d.a.l0.a.u.h.b(2003, "addEventOnCalendar fail , system error"));
                return;
            }
        }
        d(str, new d.a.l0.a.u.h.b(2003, "addEventOnCalendar fail , system error"));
    }

    public final int w(Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("account_name", "智能小程序");
        contentValues.put("account_type", "LOCAL");
        contentValues.put("calendar_displayName", "智能小程序");
        contentValues.put("visible", (Integer) 1);
        contentValues.put("calendar_access_level", (Integer) 700);
        contentValues.put("sync_events", (Integer) 1);
        contentValues.put("calendar_timezone", "Asia/Shanghai");
        contentValues.put("ownerAccount", "智能小程序");
        Uri insert = context.getContentResolver().insert(CalendarContract.Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", "智能小程序").appendQueryParameter("account_type", "LOCAL").build(), contentValues);
        if (insert == null) {
            return -1;
        }
        return (int) ContentUris.parseId(insert);
    }

    public d.a.l0.a.u.h.b x(String str) {
        Object obj;
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-CalendarApi", "start deleteEventOnCalendar");
        }
        if (l()) {
            d.a.l0.a.e0.d.b("Api-CalendarApi", "deleteEventOnCalendar does not supported when app is invisible.");
            return new d.a.l0.a.u.h.b(1001, "deleteEventOnCalendar does not supported when app is invisible.");
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-CalendarApi", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (bVar.a() && (obj = b2.second) != null) {
            JSONObject jSONObject = (JSONObject) obj;
            d D = D(jSONObject, 1);
            if (!D.a()) {
                return D.f44873g;
            }
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.l0.a.u.h.b(1001, "deleteEventOnCalendar requires cb");
            }
            d.a.l0.a.a2.e.i().T().g(i(), "scope_calendar", new b(optString, D));
            return new d.a.l0.a.u.h.b(0);
        }
        d.a.l0.a.e0.d.b("Api-CalendarApi", "parse fail");
        return bVar;
    }

    public final void y(d dVar, String str) {
        if (z() == -1) {
            d(str, new d.a.l0.a.u.h.b(2102, "deleteEventOnCalendar fail , system error"));
            return;
        }
        int delete = i().getContentResolver().delete(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, dVar.f44872f), null, null);
        if (delete < 0) {
            d(str, new d.a.l0.a.u.h.b(2102, "deleteEventOnCalendar fail , system error"));
        } else if (delete == 0) {
            d(str, new d.a.l0.a.u.h.b(2101, "deleteEventOnCalendar fail , event not found"));
        } else {
            d(str, new d.a.l0.a.u.h.b(0));
        }
    }

    public final int z() {
        if (this.f44857d == -1) {
            this.f44857d = E();
        }
        return this.f44857d;
    }
}
