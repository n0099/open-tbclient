package com.kascend.chushou.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.kascend.chushou.constants.MyUserInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public class h {
    private static h nnG;
    public List<String> f;
    private String o;
    private List<String> r;
    private String h = null;
    private String i = null;
    private boolean j = true;
    public boolean a = false;
    private String k = "2";
    public boolean b = true;
    private String l = null;
    private String m = null;
    private int n = -1;
    public boolean c = true;
    private boolean p = false;
    private boolean q = false;
    private boolean s = true;
    private boolean t = true;
    public boolean d = false;
    public boolean e = true;
    private List<Integer> u = new ArrayList();

    public static h dMp() {
        if (nnG == null) {
            synchronized (h.class) {
                if (nnG == null) {
                    nnG = new h();
                    nnG.x();
                }
            }
        }
        return nnG;
    }

    private h() {
    }

    private void x() {
        SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.h = sharedPreferences.getString("user_id", null);
        this.i = sharedPreferences.getString("nick_name", null);
        this.a = sharedPreferences.getBoolean("open_hardware", tv.chushou.zues.utils.a.eaf());
        this.j = sharedPreferences.getBoolean("only_wifi", true);
        this.b = sharedPreferences.getBoolean("show_video_barrage", true);
        this.k = sharedPreferences.getString("choose_source", "2");
        this.c = sharedPreferences.getBoolean("hotword_anim", true);
        this.o = sharedPreferences.getString("pre_key_room_toast_content", "");
        this.s = sharedPreferences.getBoolean("pre_key_auto_popup_redpacket", true);
        this.t = sharedPreferences.getBoolean("pre_key_first_redpacket_config_dialog", true);
        this.d = sharedPreferences.getBoolean("pre_key_room_danmu_open", false);
        this.e = sharedPreferences.getBoolean("pre_key_room_danmu_full_open", false);
        this.p = sharedPreferences.getBoolean("pre_key_room_toast_newuser_danmu", false);
        this.q = sharedPreferences.getBoolean("pre_key_room_toast_newuser_gift", false);
    }

    public String b() {
        return this.h;
    }

    private void f(String str) {
        this.h = str;
        SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        if (this.h != null) {
            edit.putString("user_id", this.h);
        } else {
            edit.remove("user_id");
        }
        edit.apply();
    }

    public String c() {
        return this.i;
    }

    private void g(String str) {
        this.i = str;
        SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        if (this.h != null) {
            edit.putString("nick_name", this.h);
        } else {
            edit.remove("nick_name");
        }
        edit.apply();
    }

    public void a(Context context, boolean z) {
        this.a = z;
        SharedPreferences.Editor edit = context.getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        edit.putBoolean("open_hardware", z);
        edit.apply();
    }

    public void a(Context context, String str) {
        this.k = str;
        SharedPreferences.Editor edit = context.getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        edit.putString("choose_source", str);
        edit.apply();
    }

    public String d() {
        return this.k;
    }

    public void a(boolean z) {
        if (this.b != z) {
            this.b = z;
            SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
            edit.putBoolean("show_video_barrage", z);
            edit.apply();
        }
    }

    private SharedPreferences.Editor dMq() {
        return tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
    }

    private void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            editor.commit();
        }
    }

    private void a(String str, SharedPreferences.Editor editor) {
        boolean z = false;
        if (editor == null) {
            editor = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
            z = true;
        }
        if (str != null) {
            editor.putString("pocket_json", str);
        } else {
            editor.remove("pocket_json");
        }
        if (z) {
            editor.apply();
        }
    }

    public String e() {
        return this.l;
    }

    public void b(String str, SharedPreferences.Editor editor) {
        boolean z = false;
        this.l = str;
        if (editor == null) {
            editor = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
            z = true;
        }
        if (str != null) {
            editor.putString(Config.EVENT_HEAT_POINT, this.l);
        } else {
            editor.remove(Config.EVENT_HEAT_POINT);
        }
        if (z) {
            editor.apply();
        }
    }

    public String f() {
        return this.m;
    }

    public void a(String str) {
        this.m = str;
    }

    public int g() {
        return this.n;
    }

    public void a(int i) {
        this.n = i;
    }

    public void h() {
        SharedPreferences.Editor dMq = dMq();
        g((String) null);
        f((String) null);
        b(null, dMq);
        a((String) null);
        a(-1);
        a((String) null, dMq);
        a(dMq);
    }

    public void a(MyUserInfo myUserInfo) {
        if (myUserInfo != null) {
            SharedPreferences.Editor dMq = dMq();
            f(myUserInfo.mUserID);
            g(myUserInfo.mNickname);
            a(dMq);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0063 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0065 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0012 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.io.ObjectOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.io.ObjectOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.io.ObjectOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.io.ObjectOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: java.io.ObjectOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a A[Catch: IOException -> 0x005e, TRY_LEAVE, TryCatch #5 {IOException -> 0x005e, blocks: (B:22:0x0055, B:24:0x005a), top: B:38:0x0055 }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.ObjectOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, Object obj) {
        ObjectOutputStream objectOutputStream = "com_kascend_chushou_prefs";
        SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(obj);
                    String str2 = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(str, str2);
                    edit.apply();
                    try {
                        byteArrayOutputStream.close();
                        if (objectOutputStream != 0) {
                            objectOutputStream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    try {
                        byteArrayOutputStream.close();
                        if (objectOutputStream != 0) {
                            objectOutputStream.close();
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                th = th;
                try {
                    byteArrayOutputStream.close();
                    if (objectOutputStream != 0) {
                        objectOutputStream.close();
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            objectOutputStream = 0;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream = 0;
            byteArrayOutputStream.close();
            if (objectOutputStream != 0) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [357=5, 358=5, 359=5, 361=5, 362=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x0081 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x0083 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x0085 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x0087 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:0x0020 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0078 A[Catch: IOException -> 0x007c, TRY_LEAVE, TryCatch #12 {IOException -> 0x007c, blocks: (B:42:0x0073, B:44:0x0078), top: B:67:0x0073 }] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> T RV(String str) {
        Throwable th;
        ObjectInputStream objectInputStream;
        T t = null;
        SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0);
        boolean contains = sharedPreferences.contains(str);
        if (contains) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(sharedPreferences.getString(str, null), 0));
            try {
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        t = (T) objectInputStream.readObject();
                        try {
                            byteArrayInputStream.close();
                            contains = objectInputStream;
                            if (objectInputStream != null) {
                                objectInputStream.close();
                                contains = objectInputStream;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            contains = objectInputStream;
                        }
                    } catch (StreamCorruptedException e2) {
                        e = e2;
                        e.printStackTrace();
                        try {
                            byteArrayInputStream.close();
                            contains = objectInputStream;
                            if (objectInputStream != null) {
                                objectInputStream.close();
                                contains = objectInputStream;
                            }
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            contains = objectInputStream;
                        }
                        return t;
                    } catch (IOException e4) {
                        e = e4;
                        e.printStackTrace();
                        try {
                            byteArrayInputStream.close();
                            contains = objectInputStream;
                            if (objectInputStream != null) {
                                objectInputStream.close();
                                contains = objectInputStream;
                            }
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            contains = objectInputStream;
                        }
                        return t;
                    } catch (ClassNotFoundException e6) {
                        e = e6;
                        e.printStackTrace();
                        try {
                            byteArrayInputStream.close();
                            contains = objectInputStream;
                            if (objectInputStream != null) {
                                objectInputStream.close();
                                contains = objectInputStream;
                            }
                        } catch (IOException e7) {
                            e7.printStackTrace();
                            contains = objectInputStream;
                        }
                        return t;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        byteArrayInputStream.close();
                        if (contains != 0) {
                            contains.close();
                        }
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                    throw th;
                }
            } catch (StreamCorruptedException e9) {
                e = e9;
                objectInputStream = null;
            } catch (IOException e10) {
                e = e10;
                objectInputStream = null;
            } catch (ClassNotFoundException e11) {
                e = e11;
                objectInputStream = null;
            } catch (Throwable th3) {
                contains = 0;
                th = th3;
                byteArrayInputStream.close();
                if (contains != 0) {
                }
                throw th;
            }
        }
        return t;
    }

    public void a(Object obj) {
        if (obj != null) {
            a("hotword", obj);
        }
    }

    public Object dMr() {
        return dMp().RV("hotword");
    }

    public void b(boolean z) {
        this.c = z;
        SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        edit.putBoolean("hotword_anim", z);
        edit.apply();
    }

    public void b(String str) {
        if (this.r == null) {
            this.r = new ArrayList();
        }
        this.r.add(str);
    }

    public String j() {
        return this.o;
    }

    public void c(String str) {
        this.o = str;
        SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        edit.putString("pre_key_room_toast_content", str);
        edit.apply();
    }

    public boolean k() {
        return this.p;
    }

    public void c(boolean z) {
        this.p = z;
        SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        edit.putBoolean("pre_key_room_toast_newuser_danmu", z);
        edit.apply();
    }

    public boolean l() {
        return this.q;
    }

    public void d(boolean z) {
        this.q = z;
        SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        edit.putBoolean("pre_key_room_toast_newuser_gift", z);
        edit.apply();
    }

    public int m() {
        return tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).getInt("pre_key_room_danmu_loc", 1);
    }

    public void b(int i) {
        SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        edit.putInt("pre_key_room_danmu_loc", i);
        edit.apply();
    }

    public boolean n() {
        return this.d;
    }

    public void e(boolean z) {
        this.d = z;
        SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        edit.putBoolean("pre_key_room_danmu_open", z);
        edit.apply();
    }

    public boolean o() {
        return this.e;
    }

    public void f(boolean z) {
        this.e = z;
        SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        edit.putBoolean("pre_key_room_danmu_full_open", z);
        edit.apply();
    }

    public String p() {
        return tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).getString("pre_key_ad_interval_time", "");
    }

    public void d(String str) {
        SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        edit.putString("pre_key_ad_interval_time", str);
        edit.apply();
    }

    public boolean q() {
        return this.s;
    }

    public void g(boolean z) {
        this.s = z;
        SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        edit.putBoolean("pre_key_auto_popup_redpacket", z);
        edit.apply();
    }

    public boolean r() {
        return this.t;
    }

    public void h(boolean z) {
        this.t = z;
        SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        edit.putBoolean("pre_key_first_redpacket_config_dialog", z);
        edit.apply();
    }

    public String s() {
        return tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).getString("pre_key_last_token", "");
    }

    public void e(String str) {
        SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        edit.putString("pre_key_last_token", str);
        edit.apply();
    }

    public Set<String> dMs() {
        Set<String> stringSet = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).getStringSet("show_firstrecharge_h5", null);
        return stringSet != null ? new HashSet(stringSet) : new HashSet();
    }

    public void a(Set<String> set) {
        SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        edit.putStringSet("show_firstrecharge_h5", set);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        return this.j;
    }

    public void c(int i) {
        if (this.u.size() <= 1 || this.u.get(0).intValue() != i) {
            Iterator<Integer> it = this.u.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().intValue() == i) {
                    it.remove();
                    break;
                }
            }
            this.u.add(0, Integer.valueOf(i));
            if (this.u.size() > 20) {
                this.u.remove(20);
            }
            SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
            edit.putString("pre_key_commonly_gift", tv.chushou.zues.utils.d.toJson(this.u));
            edit.apply();
        }
    }

    public void a(List<Integer> list) {
        if (list == null || list.size() != this.u.size()) {
            this.u.clear();
            if (list != null) {
                this.u.addAll(list);
            }
            SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
            edit.putString("pre_key_commonly_gift", tv.chushou.zues.utils.d.toJson(this.u));
            edit.apply();
        }
    }

    public List<Integer> dMt() {
        if (!tv.chushou.zues.utils.h.isEmpty(this.u)) {
            return this.u;
        }
        String string = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).getString("pre_key_commonly_gift", null);
        if (tv.chushou.zues.utils.h.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) tv.chushou.zues.utils.d.c(string, new com.google.gson.b.a<ArrayList<Integer>>() { // from class: com.kascend.chushou.d.h.1
        }.getType());
        if (!tv.chushou.zues.utils.h.isEmpty(arrayList)) {
            this.u.addAll(arrayList);
        }
        return this.u;
    }

    public void a(long j) {
        SharedPreferences.Editor edit = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).edit();
        edit.putLong("pre_key_exit_subscribetime", j);
        edit.apply();
    }

    public long dMu() {
        return tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0).getLong("pre_key_exit_subscribetime", 0L);
    }
}
