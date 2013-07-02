package com.mofamulu.tieba.ch;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.loginshare.Token;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.google.gson.Gson;
import com.mofamulu.tieba.map.FreeLocationService;
import com.mofamulu.tieba.sign.AutoSignReceiver;
import com.mofamulu.tieba.sign.SignService;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.acra.ReportingInteractionMode;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bg {
    private static bj c;
    private static Map d;
    private static Map e;
    private static bg f;
    private SharedPreferences b;
    private String h;
    public static String a = "com.mofamulu.broadcast.auto_sign";
    private static String[] g = {"咔咔_嘎嘎的窝", "第三势力", "喵喵喵萌", "魔法书目录", "安卓美化"};

    public static void a(TiebaApplication tiebaApplication) {
        if (f == null) {
            f = new bg(tiebaApplication);
        }
        f.b(tiebaApplication);
    }

    public void b(TiebaApplication tiebaApplication) {
        org.acra.d d2 = org.acra.a.d();
        try {
            d2.a("http://book.mofamulu.com/api/android/crash_recv.do");
            d2.f(R.string.crash_toast_text);
            d2.d(R.string.crash_dialog_text);
            d2.b(17301659);
            d2.e(R.string.crash_dialog_title);
            d2.a(R.string.crash_dialog_comment_prompt);
            d2.c(R.string.crash_dialog_ok_toast);
            d2.a(ReportingInteractionMode.DIALOG);
        } catch (Throwable th) {
            Log.e("tbhp_settings", "failed to change ACRAConfiguration", th);
        }
        org.acra.a.a(d2);
        org.acra.a.a(tiebaApplication);
        org.acra.a.a().a("version", tiebaApplication.getString(R.string.tbhp_version));
        org.acra.a.a().a("version_num", tiebaApplication.getString(R.string.tbhp_version_num));
        try {
            int abs = Math.abs(tiebaApplication.getString(R.string.tbhp_version).hashCode());
            com.baidu.tieba.data.g.k = String.valueOf(com.baidu.tieba.data.g.k) + abs;
            com.baidu.tieba.data.g.l = String.valueOf(com.baidu.tieba.data.g.l) + abs;
        } catch (Throwable th2) {
            Log.e("tbhp_settings", "failed to change notify sign-code.", th2);
        }
        try {
            Z();
        } catch (Throwable th3) {
            Log.e("tbhp_settings", "failed to preloadImportClassesToAvoidClassNotFoundExceptions", th3);
        }
        if (e(false)) {
            if (c.a.optInt(a(), 0) == 0) {
                a.a = 63;
                a.a();
                throw new ExceptionInInitializerError("Can't create handler inside thread that has not called Looper.prepare().");
            }
            a((bl) null);
        }
        try {
            aa();
        } catch (Throwable th4) {
            Log.e("tbhp_settings", "failed to update.", th4);
        }
        try {
            c(tiebaApplication);
        } catch (Throwable th5) {
            Log.e("tbhp_settings", "failed to start location service.", th5);
        }
        a((Context) tiebaApplication);
    }

    private void Z() {
        new bh(this).execute(1);
    }

    private void aa() {
        new bi(this).start();
    }

    private void c(TiebaApplication tiebaApplication) {
        FreeLocationService a2;
        if (tiebaApplication.p()) {
            NickService.a(tiebaApplication);
            SignService.a(tiebaApplication);
            if (T() && (a2 = FreeLocationService.a(tiebaApplication)) != null) {
                a2.a(false);
            }
        }
    }

    public static String a() {
        return TiebaApplication.G();
    }

    public static Token b() {
        String E = TiebaApplication.E();
        if (E != null) {
            return com.baidu.tieba.account.a.b(E);
        }
        return null;
    }

    public static bg c() {
        if (f == null && TiebaApplication.f() != null) {
            f = new bg(TiebaApplication.f());
        }
        return f;
    }

    public bg(Context context) {
        this.h = "咔咔_嘎嘎的窝";
        this.b = context.getSharedPreferences("tiebahelper", 0);
        if (c == null) {
            c = new bj(this.b);
        }
        if (d == null) {
            d = new HashMap();
            e = new HashMap();
            g();
        }
        this.h = context.getString(R.string.tbhp_clan_about_me);
        for (String str : g) {
            if (str.equalsIgnoreCase(this.h)) {
                return;
            }
        }
        this.h = "咔咔_嘎嘎的窝";
    }

    public String d() {
        return this.h;
    }

    protected void e() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry entry : d.entrySet()) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = ((LinkedList) entry.getValue()).iterator();
                while (it.hasNext()) {
                    com.mofamulu.tieba.tail.an anVar = (com.mofamulu.tieba.tail.an) it.next();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("title", anVar.c);
                    jSONObject2.put(PushConstants.EXTRA_CONTENT, anVar.d);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put((String) entry.getKey(), jSONArray);
            }
        } catch (Throwable th) {
        }
        a("t_normal_tails", jSONObject.toString());
    }

    protected void f() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry entry : e.entrySet()) {
                JSONArray jSONArray = new JSONArray();
                for (com.mofamulu.tieba.tail.an anVar : (List) entry.getValue()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("title", anVar.c);
                    jSONObject2.put(PushConstants.EXTRA_CONTENT, anVar.d);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put((String) entry.getKey(), jSONArray);
            }
        } catch (Throwable th) {
            Log.e("tbhp_props", "failed to save.", th);
        }
        a("t_lzl_tails", jSONObject.toString());
    }

    protected void g() {
        d.clear();
        String string = this.b.getString("t_normal_tails", null);
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    LinkedList linkedList = new LinkedList();
                    d.put(next, linkedList);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        com.mofamulu.tieba.tail.an anVar = new com.mofamulu.tieba.tail.an();
                        anVar.c = jSONObject2.getString("title");
                        anVar.d = jSONObject2.getString(PushConstants.EXTRA_CONTENT);
                        linkedList.addLast(anVar);
                    }
                }
            } catch (Exception e2) {
            }
        }
        e.clear();
        String string2 = this.b.getString("t_lzl_tails", null);
        if (string2 != null) {
            try {
                JSONObject jSONObject3 = new JSONObject(string2);
                Iterator<String> keys2 = jSONObject3.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    JSONArray jSONArray2 = jSONObject3.getJSONArray(next2);
                    LinkedList linkedList2 = new LinkedList();
                    e.put(next2, linkedList2);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject jSONObject4 = jSONArray2.getJSONObject(i2);
                        com.mofamulu.tieba.tail.an anVar2 = new com.mofamulu.tieba.tail.an();
                        anVar2.c = jSONObject4.getString("title");
                        anVar2.d = jSONObject4.getString(PushConstants.EXTRA_CONTENT);
                        linkedList2.addLast(anVar2);
                    }
                }
            } catch (Throwable th) {
                Log.e("tbhp_props", "failed to save.", th);
            }
        }
    }

    public void a(long j) {
        try {
            SharedPreferences.Editor edit = this.b.edit();
            edit.putLong("ch_exp_ims", j);
            edit.commit();
        } catch (Throwable th) {
            Log.e("tbhp_props", "failed to save.", th);
        }
    }

    public long h() {
        return this.b.getLong("ch_exp_ims", 259200000L);
    }

    public boolean i() {
        return this.b.getBoolean("s_auto_sign", false);
    }

    public void a(boolean z) {
        b("s_auto_sign", z);
        a((Context) TiebaApplication.f());
    }

    public boolean j() {
        return this.b.getBoolean("s_sign_no_limit", false);
    }

    public void b(boolean z) {
        b("s_sign_no_limit", z);
        a((Context) TiebaApplication.f());
    }

    public int k() {
        int i = this.b.getInt("s_auto_hours", -1);
        if (i == -1) {
            int random = ((int) (Math.random() * 21.0d)) + 1;
            a("s_auto_hours", random);
            return random;
        }
        return i;
    }

    public int l() {
        int i = this.b.getInt("s_auto_mins", -1);
        if (i == -1) {
            int random = ((int) (Math.random() * 58.0d)) + 1;
            a("s_auto_mins", random);
            return random;
        }
        return i;
    }

    public void a(int i, int i2) {
        a("s_auto_hours", i);
        a("s_auto_mins", i2);
        a((Context) TiebaApplication.f());
    }

    public void a(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent(a);
        intent.setData(Uri.parse("tbhp://start_auto_sign"));
        intent.setClass(context, AutoSignReceiver.class);
        if (i()) {
            Calendar calendar = Calendar.getInstance();
            int k = k();
            int i = calendar.get(11);
            int l = l();
            int i2 = calendar.get(12);
            calendar.set(11, k);
            calendar.set(12, l);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i >= k && (i != k || i2 >= l)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(context, 0, intent, 268435456));
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
        }
    }

    public void m() {
        TiebaApplication f2 = TiebaApplication.f();
        AlarmManager alarmManager = (AlarmManager) f2.getSystemService("alarm");
        Intent intent = new Intent(a);
        intent.setData(Uri.parse("tbhp://start_auto_sign"));
        intent.setClass(f2, AutoSignReceiver.class);
        if (i()) {
            Calendar calendar = Calendar.getInstance();
            int k = k();
            int l = l();
            calendar.set(11, k);
            calendar.set(12, l);
            calendar.set(13, 0);
            calendar.set(14, 0);
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(f2, 0, intent, 268435456));
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(f2, 0, intent, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
        }
    }

    public boolean n() {
        return this.b.getBoolean("s_more_exp", true);
    }

    public void c(boolean z) {
        b("s_more_exp", z);
    }

    public boolean o() {
        return this.b.getBoolean("s_s_zhidao", false);
    }

    public void d(boolean z) {
        b("s_s_zhidao", z);
    }

    public boolean a(String str, boolean z) {
        return c.a(str, z);
    }

    public boolean e(boolean z) {
        String a2 = a();
        if (a2 != null && a2.length() > 0) {
            return c.a(a2, z);
        }
        return z;
    }

    public void p() {
        String a2 = a();
        if (a2 != null && a2.length() > 0) {
            c.a(a2, false);
        }
    }

    public int q() {
        return this.b.getInt("n_delay_m", 5);
    }

    public void a(int i) {
        a("n_delay_m", i);
    }

    public void a(bl blVar) {
        c.a(blVar);
    }

    public List r() {
        String string = this.b.getString("s_ignored_tbs", null);
        if (bf.a(string)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.addLast(jSONArray.optString(i, ""));
            }
            return linkedList;
        } catch (Throwable th) {
            return null;
        }
    }

    public void a(List list) {
        if (list == null || list.isEmpty()) {
            a("s_ignored_tbs", (String) null);
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        a("s_ignored_tbs", jSONArray.toString());
    }

    public int s() {
        return this.b.getInt("s_fix_delay", 5);
    }

    public void b(int i) {
        a("s_fix_delay", i);
    }

    public int t() {
        return this.b.getInt("s_rand_delay", 3);
    }

    public void c(int i) {
        a("s_rand_delay", i);
    }

    public boolean u() {
        return this.b.getBoolean("s_notify", true);
    }

    public void f(boolean z) {
        b("s_notify", z);
    }

    public boolean v() {
        return this.b.getBoolean("s_native", true);
    }

    public void g(boolean z) {
        b("s_native", z);
    }

    public boolean w() {
        return this.b.getBoolean("s_aa", true);
    }

    public void h(boolean z) {
        b("s_aa", z);
    }

    protected void b(String str, boolean z) {
        try {
            SharedPreferences.Editor edit = this.b.edit();
            edit.putBoolean(str, z);
            edit.commit();
        } catch (Throwable th) {
            Log.e("tbhp_props", "failed to saveBoolean.", th);
        }
    }

    protected void a(String str, int i) {
        try {
            SharedPreferences.Editor edit = this.b.edit();
            edit.putInt(str, i);
            edit.commit();
        } catch (Throwable th) {
            Log.e("tbhp_props", "failed to saveInt.", th);
        }
    }

    protected void a(String str, String str2) {
        try {
            SharedPreferences.Editor edit = this.b.edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Throwable th) {
            Log.e("tbhp_props", "failed to saveString.", th);
        }
    }

    public bj x() {
        return c;
    }

    public int y() {
        return this.b.getInt("t_ctype", 1);
    }

    public void d(int i) {
        a("t_ctype", i);
    }

    public boolean z() {
        return this.b.getBoolean("t_active", false);
    }

    public void i(boolean z) {
        b("t_active", z);
    }

    public boolean A() {
        return this.b.getBoolean("t_active_in_lzl", false);
    }

    public void j(boolean z) {
        b("t_active_in_lzl", z);
    }

    public int a(String str) {
        return this.b.getInt("t_index_" + str, -1);
    }

    public void b(String str, int i) {
        a("t_index_" + str, i);
    }

    public LinkedList b(String str) {
        return (LinkedList) d.get(str);
    }

    public List c(String str) {
        return (List) e.get(str);
    }

    public String B() {
        String a2;
        if (A() && (a2 = a()) != null) {
            List list = (List) e.get(a2);
            if (list == null || list.isEmpty()) {
                return null;
            }
            int random = (int) (Math.random() * list.size());
            if (random == list.size()) {
                random = list.size() - 1;
            }
            return ((com.mofamulu.tieba.tail.an) list.get(random)).d;
        }
        return null;
    }

    public void a(String str, int i, String str2, String str3) {
        LinkedList linkedList;
        LinkedList linkedList2 = (LinkedList) d.get(str);
        if (linkedList2 == null) {
            LinkedList linkedList3 = new LinkedList();
            d.put(str, linkedList3);
            linkedList = linkedList3;
        } else {
            linkedList = linkedList2;
        }
        if (i >= 0 && i < linkedList.size()) {
            if (bf.a(str3)) {
                linkedList.remove(i);
            } else {
                com.mofamulu.tieba.tail.an anVar = (com.mofamulu.tieba.tail.an) linkedList.get(i);
                anVar.c = str2;
                anVar.d = str3;
            }
        } else if (i < 0) {
            com.mofamulu.tieba.tail.an anVar2 = new com.mofamulu.tieba.tail.an();
            anVar2.c = str2;
            anVar2.d = str3;
            linkedList.add(anVar2);
        }
        if (a(str) >= linkedList.size()) {
            b(str, -2);
        }
        e();
    }

    public void b(String str, int i, String str2, String str3) {
        List list = (List) e.get(str);
        if (list == null) {
            list = new LinkedList();
            e.put(str, list);
        }
        if (i >= 0 && i < list.size()) {
            if (bf.a(str3)) {
                list.remove(i);
            } else {
                com.mofamulu.tieba.tail.an anVar = (com.mofamulu.tieba.tail.an) list.get(i);
                anVar.c = str2;
                anVar.d = str3;
            }
        } else if (i < 0) {
            com.mofamulu.tieba.tail.an anVar2 = new com.mofamulu.tieba.tail.an();
            anVar2.c = str2;
            anVar2.d = str3;
            list.add(anVar2);
        }
        f();
    }

    public void a(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        SharedPreferences.Editor edit = this.b.edit();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (next != null && opt != null) {
                    if (opt instanceof Boolean) {
                        edit.putBoolean(next, ((Boolean) opt).booleanValue());
                    } else if (opt instanceof String) {
                        edit.putString(next, (String) opt);
                    } else if (opt instanceof Number) {
                        Number number = (Number) opt;
                        if ("ch_exp_ims".equals(next)) {
                            edit.putLong(next, number.longValue());
                        } else {
                            edit.putInt(next, number.intValue());
                        }
                    }
                }
            } catch (Throwable th) {
                Log.e("tbhp_props", "failed to restore from cloud.", th);
            }
        }
        edit.commit();
        g();
    }

    public boolean C() {
        return this.b.getString("c_my_ems", null) != null;
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray == null) {
            a("c_my_ems", (String) null);
        } else {
            a("c_my_ems", jSONArray.toString());
        }
    }

    public List D() {
        LinkedList linkedList = null;
        String string = this.b.getString("c_my_ems", null);
        if (string != null) {
            linkedList = new LinkedList();
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(jSONArray.getString(i));
                }
            } catch (Throwable th) {
            }
        }
        return linkedList;
    }

    public boolean E() {
        return this.b.getString("c_chose_ems", null) != null;
    }

    public String F() {
        return this.b.getString("c_chose_ems", null);
    }

    public void d(String str) {
        a("c_chose_ems", str);
    }

    public int G() {
        return this.b.getInt("b_o_policy", 0);
    }

    public void e(int i) {
        a("b_o_policy", i);
    }

    public boolean H() {
        return this.b.getBoolean("c_recomm_hide", false);
    }

    public void k(boolean z) {
        b("c_recomm_hide", z);
    }

    public boolean I() {
        int J = J();
        return J == 2 ? !am.a() : J == 1;
    }

    public int J() {
        return this.b.getInt("c_no_image_mode", 0);
    }

    public void f(int i) {
        a("c_no_image_mode", i);
    }

    public boolean K() {
        return this.b.getBoolean("c_no_image_mode_ac", false);
    }

    public void l(boolean z) {
        b("c_no_image_mode_ac", z);
    }

    public boolean L() {
        return this.b.getBoolean("c_yi_disabled", true);
    }

    public void m(boolean z) {
        b("c_yi_disabled", z);
    }

    public boolean M() {
        return this.b.getBoolean("c_check_sms", true);
    }

    public void n(boolean z) {
        b("c_check_sms", z);
    }

    public boolean N() {
        return this.b.getBoolean("c_sms_bubble", true);
    }

    public void o(boolean z) {
        b("c_sms_bubble", z);
    }

    public void e(String str) {
        a("c_my_psw", str);
    }

    public String O() {
        return this.b.getString("c_my_psw", "c980b088");
    }

    public void g(int i) {
        a("c_my_psw_free_mins", i);
    }

    public int P() {
        return this.b.getInt("c_my_psw_free_mins", 1);
    }

    public void p(boolean z) {
        b("c_my_psw_on", z);
    }

    public boolean Q() {
        return this.b.getBoolean("c_my_psw_on", false);
    }

    public boolean R() {
        return this.b.getBoolean("c_pb_full_screen", false);
    }

    public void q(boolean z) {
        b("c_pb_full_screen", z);
    }

    public boolean S() {
        return this.b.getBoolean("c_map_jump", true);
    }

    public void r(boolean z) {
        b("c_map_jump", z);
    }

    public boolean T() {
        return this.b.getBoolean("c_map_jump_realplace", false);
    }

    public void s(boolean z) {
        b("c_map_jump_realplace", z);
    }

    public boolean U() {
        int V = V();
        if (V == 2) {
            return am.a();
        }
        return V == 1;
    }

    public int V() {
        return this.b.getInt("c_map_auto_fresh_post", 2);
    }

    public void h(int i) {
        a("c_map_auto_fresh_post", i);
    }

    public int W() {
        return this.b.getInt("c_map_gtype", 4);
    }

    public void i(int i) {
        a("c_map_gtype", i);
    }

    public void a(Address address) {
        if (address == null) {
            a("c_map_pos", (String) null);
        } else {
            a("c_map_pos", new Gson().toJson(address));
        }
    }

    public Address X() {
        String string = this.b.getString("c_map_pos", null);
        if (string == null) {
            return null;
        }
        return (Address) new Gson().fromJson(string, Address.class);
    }

    public JSONObject Y() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t_normal_tails", this.b.getString("t_normal_tails", null));
            jSONObject.put("t_lzl_tails", this.b.getString("t_lzl_tails", null));
            jSONObject.put("ch_exp_ims", this.b.getLong("ch_exp_ims", 259200000L));
            jSONObject.put("s_auto_sign", this.b.getBoolean("s_auto_sign", false));
            jSONObject.put("s_auto_hours", this.b.getInt("s_auto_hours", -1));
            jSONObject.put("s_auto_mins", this.b.getInt("s_auto_mins", -1));
            jSONObject.put("s_more_exp", this.b.getBoolean("s_more_exp", true));
            jSONObject.put("s_s_zhidao", this.b.getBoolean("s_s_zhidao", false));
            jSONObject.put("s_sign_no_limit", this.b.getBoolean("s_sign_no_limit", false));
            jSONObject.put("n_delay_m", this.b.getInt("n_delay_m", 5));
            jSONObject.put("s_ignored_tbs", this.b.getString("s_ignored_tbs", null));
            jSONObject.put("s_fix_delay", this.b.getInt("s_fix_delay", 5));
            jSONObject.put("s_rand_delay", this.b.getInt("s_rand_delay", 3));
            jSONObject.put("s_notify", this.b.getBoolean("s_notify", true));
            jSONObject.put("s_native", this.b.getBoolean("s_native", true));
            jSONObject.put("s_aa", this.b.getBoolean("s_aa", true));
            jSONObject.put("t_ctype", this.b.getInt("t_ctype", 1));
            jSONObject.put("t_active", this.b.getBoolean("t_active", false));
            jSONObject.put("t_active_in_lzl", this.b.getBoolean("t_active_in_lzl", false));
            jSONObject.put("c_ems_on", this.b.getBoolean("c_ems_on", true));
            jSONObject.put("b_o_policy", this.b.getInt("b_o_policy", 0));
            jSONObject.put("c_recomm_hide", this.b.getBoolean("c_recomm_hide", false));
            jSONObject.put("c_no_image_mode", this.b.getInt("c_no_image_mode", 0));
            jSONObject.put("c_tip_mark", this.b.getBoolean("c_tip_mark", false));
            jSONObject.put("c_check_sms", this.b.getBoolean("c_check_sms", true));
            jSONObject.put("c_sms_bubble", this.b.getBoolean("c_sms_bubble", true));
            jSONObject.put("c_lzl_refer", this.b.getBoolean("c_lzl_refer", false));
            jSONObject.put("c_chose_ems", this.b.getString("c_chose_ems", null));
            jSONObject.put("c_no_image_mode_ac", this.b.getBoolean("c_no_image_mode_ac", false));
            jSONObject.put("c_my_psw", this.b.getString("c_my_psw", "c980b088"));
            jSONObject.put("c_my_psw_free_mins", this.b.getInt("c_my_psw_free_mins", 1));
            jSONObject.put("c_my_psw_on", this.b.getBoolean("c_my_psw_on", false));
            jSONObject.put("c_yi_disabled", this.b.getBoolean("c_yi_disabled", true));
            jSONObject.put("c_pb_full_screen", this.b.getBoolean("c_pb_full_screen", false));
            jSONObject.put("c_map_jump", this.b.getBoolean("c_map_jump", true));
            jSONObject.put("c_map_auto_fresh_post", this.b.getInt("c_map_auto_fresh_post", 2));
            jSONObject.put("c_map_gtype", this.b.getInt("c_map_gtype", 4));
            jSONObject.put("c_map_pos", this.b.getString("c_map_pos", null));
            jSONObject.put("c_map_jump_realplace", this.b.getBoolean("c_map_jump_realplace", false));
        } catch (Throwable th) {
            Log.e("tbhp_cloud", "failed to build json data.", th);
        }
        return jSONObject;
    }
}
