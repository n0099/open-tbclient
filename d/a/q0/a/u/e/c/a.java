package d.a.q0.a.u.e.c;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.e2.c.i;
import d.a.q0.a.e2.c.j.b;
import d.a.q0.a.s1.e;
import d.a.q0.a.s1.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.q0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final String f50782e;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f50783f;

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f50784g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public int f50785d;

    /* renamed from: d.a.q0.a.u.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0954a implements d.a.q0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50786e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f50787f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f50788g;

        public C0954a(a aVar, String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50788g = aVar;
            this.f50786e = str;
            this.f50787f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.q0.a.e2.c.d.h(iVar)) {
                    this.f50788g.B(this.f50786e, this.f50787f);
                } else {
                    this.f50788g.d(this.f50786e, new d.a.q0.a.u.h.b(iVar.b(), d.a.q0.a.e2.c.d.f(iVar.b())));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.q0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f50790f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f50791g;

        public b(a aVar, String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50791g = aVar;
            this.f50789e = str;
            this.f50790f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.q0.a.e2.c.d.h(iVar)) {
                    this.f50791g.B(this.f50789e, this.f50790f);
                } else {
                    this.f50791g.d(this.f50789e, new d.a.q0.a.u.h.b(iVar.b(), d.a.q0.a.e2.c.d.f(iVar.b())));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f50792a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50793b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f50794c;

        public c(a aVar, d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50794c = aVar;
            this.f50792a = dVar;
            this.f50793b = str;
        }

        @Override // d.a.q0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d dVar = this.f50792a;
                int i2 = dVar.f50802h;
                if (i2 == 0) {
                    this.f50794c.v(dVar, this.f50793b);
                } else if (i2 != 1) {
                } else {
                    this.f50794c.y(dVar, this.f50793b);
                }
            }
        }

        @Override // d.a.q0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f50794c.d(this.f50793b, new d.a.q0.a.u.h.b(i2, str));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f50795a;

        /* renamed from: b  reason: collision with root package name */
        public long f50796b;

        /* renamed from: c  reason: collision with root package name */
        public long f50797c;

        /* renamed from: d  reason: collision with root package name */
        public String f50798d;

        /* renamed from: e  reason: collision with root package name */
        public int f50799e;

        /* renamed from: f  reason: collision with root package name */
        public long f50800f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.q0.a.u.h.b f50801g;

        /* renamed from: h  reason: collision with root package name */
        public int f50802h;

        public d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50802h = i2;
            this.f50800f = -1L;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.q0.a.u.h.b bVar = this.f50801g;
                return bVar != null && bVar.isSuccess();
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2111917085, "Ld/a/q0/a/u/e/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2111917085, "Ld/a/q0/a/u/e/c/a;");
                return;
            }
        }
        f50782e = SchemeConfig.getSchemeHead() + "://swan/";
        f50783f = new String[]{"_id", "account_name", "calendar_displayName"};
        f50784g = new String[]{"_id", "calendar_id", "title", "dtstart", "dtend"};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.q0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50785d = -1;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION, THROW, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final long A(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            Cursor query = i().getContentResolver().query(CalendarContract.Events.CONTENT_URI, f50784g, "((account_name = ?))", new String[]{"智能小程序"}, null);
            if (query != null) {
                try {
                    if (query.getCount() >= 1) {
                        query.moveToFirst();
                        do {
                            long j = query.getLong(query.getColumnIndex("_id"));
                            String string = query.getString(query.getColumnIndex("title"));
                            long j2 = query.getLong(query.getColumnIndex("dtstart"));
                            long j3 = query.getLong(query.getColumnIndex("dtend"));
                            if (TextUtils.equals(dVar.f50795a, string) && j2 == dVar.f50796b && j3 == dVar.f50797c) {
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
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public final void B(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
            e.g(new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"}, 4, i(), new c(this, dVar, str));
        }
    }

    public final void C(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TbEnum.SystemMessage.KEY_EVENT_ID, j + "");
            } catch (JSONException e2) {
                if (d.a.q0.a.u.c.d.f50740c) {
                    e2.printStackTrace();
                }
            }
            d(str, new d.a.q0.a.u.h.b(0, jSONObject));
        }
    }

    public final d D(JSONObject jSONObject, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, jSONObject, i2)) == null) {
            d dVar = new d(i2);
            if (i2 == 0) {
                String optString = jSONObject.optString("title");
                dVar.f50795a = optString;
                if (TextUtils.isEmpty(optString)) {
                    d.a.q0.a.e0.d.b("Api-CalendarApi", "addEventOnCalendar requires a valid title");
                    dVar.f50801g = new d.a.q0.a.u.h.b(1001, "addEventOnCalendar requires a valid title");
                    return dVar;
                }
                long optLong = jSONObject.optLong("startTime", -1L);
                dVar.f50796b = optLong;
                if (optLong == -1) {
                    d.a.q0.a.e0.d.b("Api-CalendarApi", "addEventOnCalendar requires a valid startTime");
                    dVar.f50801g = new d.a.q0.a.u.h.b(1001, "addEventOnCalendar requires a valid startTime");
                    return dVar;
                }
                long optLong2 = jSONObject.optLong("endTime", -1L);
                dVar.f50797c = optLong2;
                if (optLong2 < dVar.f50796b) {
                    d.a.q0.a.e0.d.b("Api-CalendarApi", "addEventOnCalendar requires a valid endTime");
                    dVar.f50801g = new d.a.q0.a.u.h.b(1001, "addEventOnCalendar requires a valid endTime");
                    return dVar;
                }
                dVar.f50799e = jSONObject.optInt("remindMinutesBefore", 10);
                dVar.f50798d = jSONObject.optString("location");
                String optString2 = jSONObject.optString("url");
                if (!TextUtils.isEmpty(optString2)) {
                    if (optString2.startsWith(f50782e)) {
                        dVar.f50795a += " " + optString2;
                    } else {
                        dVar.f50801g = new d.a.q0.a.u.h.b(2002, "invalid url");
                        return dVar;
                    }
                }
                dVar.f50801g = new d.a.q0.a.u.h.b(0);
            } else if (i2 == 1) {
                long optLong3 = jSONObject.optLong(TbEnum.SystemMessage.KEY_EVENT_ID, -1L);
                dVar.f50800f = optLong3;
                if (optLong3 == -1) {
                    d.a.q0.a.e0.d.b("Api-CalendarApi", "deleteEventOnCalendar requires a valid eventId");
                    dVar.f50801g = new d.a.q0.a.u.h.b(1001, "deleteEventOnCalendar requires a valid eventId");
                } else {
                    dVar.f50801g = new d.a.q0.a.u.h.b(0);
                }
            }
            return dVar;
        }
        return (d) invokeLI.objValue;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Context i2 = i();
            Cursor query = i2.getContentResolver().query(CalendarContract.Calendars.CONTENT_URI, f50783f, "((account_name = ?) AND (calendar_displayName = ?))", new String[]{"智能小程序", "智能小程序"}, null);
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
        return invokeV.intValue;
    }

    public d.a.q0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (d.a.q0.a.u.c.d.f50740c) {
                Log.d("Api-CalendarApi", "start addEventOnCalendar");
            }
            if (l()) {
                d.a.q0.a.e0.d.b("Api-CalendarApi", "addEventOnCalendar does not supported when app is invisible.");
                return new d.a.q0.a.u.h.b(1001, "addEventOnCalendar does not supported when app is invisible.");
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-CalendarApi", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            if (bVar.isSuccess() && (obj = b2.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                d D = D(jSONObject, 0);
                if (!D.a()) {
                    return D.f50801g;
                }
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new d.a.q0.a.u.h.b(1001, "addEventOnCalendar requires cb");
                }
                d.a.q0.a.a2.e.i().T().g(i(), "scope_calendar", new C0954a(this, optString, D));
                return new d.a.q0.a.u.h.b(0);
            }
            d.a.q0.a.e0.d.b("Api-CalendarApi", "parse fail");
            return bVar;
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public final void v(d dVar, String str) {
        String lastPathSegment;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, dVar, str) == null) {
            int z = z();
            if (z == -1) {
                d(str, new d.a.q0.a.u.h.b(2003, "addEventOnCalendar fail , system error"));
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
            contentValues.put("dtstart", Long.valueOf(dVar.f50796b));
            contentValues.put("dtend", Long.valueOf(dVar.f50797c));
            contentValues.put("title", dVar.f50795a);
            if (!TextUtils.isEmpty(dVar.f50798d)) {
                contentValues.put("eventLocation", dVar.f50798d);
            }
            ContentResolver contentResolver = i().getContentResolver();
            Uri insert = contentResolver.insert(CalendarContract.Events.CONTENT_URI, contentValues);
            if (insert != null && (lastPathSegment = insert.getLastPathSegment()) != null) {
                try {
                    j = Long.parseLong(lastPathSegment);
                } catch (NumberFormatException e2) {
                    if (d.a.q0.a.u.c.d.f50740c) {
                        e2.printStackTrace();
                    }
                    j = -1;
                }
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(j));
                contentValues2.put("minutes", Integer.valueOf(dVar.f50799e));
                contentValues2.put("method", (Integer) 1);
                Uri insert2 = contentResolver.insert(CalendarContract.Reminders.CONTENT_URI, contentValues2);
                if (insert2 != null && ContentUris.parseId(insert2) != 0) {
                    C(str, j);
                    return;
                } else {
                    d(str, new d.a.q0.a.u.h.b(2003, "addEventOnCalendar fail , system error"));
                    return;
                }
            }
            d(str, new d.a.q0.a.u.h.b(2003, "addEventOnCalendar fail , system error"));
        }
    }

    public final int w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
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
        return invokeL.intValue;
    }

    public d.a.q0.a.u.h.b x(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (d.a.q0.a.u.c.d.f50740c) {
                Log.d("Api-CalendarApi", "start deleteEventOnCalendar");
            }
            if (l()) {
                d.a.q0.a.e0.d.b("Api-CalendarApi", "deleteEventOnCalendar does not supported when app is invisible.");
                return new d.a.q0.a.u.h.b(1001, "deleteEventOnCalendar does not supported when app is invisible.");
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-CalendarApi", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            if (bVar.isSuccess() && (obj = b2.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                d D = D(jSONObject, 1);
                if (!D.a()) {
                    return D.f50801g;
                }
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new d.a.q0.a.u.h.b(1001, "deleteEventOnCalendar requires cb");
                }
                d.a.q0.a.a2.e.i().T().g(i(), "scope_calendar", new b(this, optString, D));
                return new d.a.q0.a.u.h.b(0);
            }
            d.a.q0.a.e0.d.b("Api-CalendarApi", "parse fail");
            return bVar;
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public final void y(d dVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, dVar, str) == null) {
            if (z() == -1) {
                d(str, new d.a.q0.a.u.h.b(2102, "deleteEventOnCalendar fail , system error"));
                return;
            }
            int delete = i().getContentResolver().delete(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, dVar.f50800f), null, null);
            if (delete < 0) {
                d(str, new d.a.q0.a.u.h.b(2102, "deleteEventOnCalendar fail , system error"));
            } else if (delete == 0) {
                d(str, new d.a.q0.a.u.h.b(2101, "deleteEventOnCalendar fail , event not found"));
            } else {
                d(str, new d.a.q0.a.u.h.b(0));
            }
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f50785d == -1) {
                this.f50785d = E();
            }
            return this.f50785d;
        }
        return invokeV.intValue;
    }
}
