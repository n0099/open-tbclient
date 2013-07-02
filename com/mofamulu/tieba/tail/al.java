package com.mofamulu.tieba.tail;

import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.NetWorkCore;
import com.mofamulu.tieba.ch.NickBinder;
import com.mofamulu.tieba.ch.bf;
import com.mofamulu.tieba.ch.bg;
import com.mofamulu.tieba.map.FreeLocationService;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class al {
    private static final BasicNameValuePair a = new BasicNameValuePair("tbhp_round", "1");

    public static void a(ArrayList arrayList, boolean z) {
        String str;
        FreeLocationService a2;
        FreeLocationService a3;
        String str2;
        int i;
        int i2;
        int i3;
        String str3;
        if (arrayList != null) {
            if (com.mofamulu.tieba.ch.as.a(bg.a())) {
                arrayList.clear();
            } else if (NickBinder.b.b() != 0) {
                int i4 = 2;
                bg c = bg.c();
                if (c != null) {
                    if (c.e(false)) {
                        i4 = c.y() + 1;
                        if (c.x().a.optInt(bg.a(), 0) == 0) {
                            com.mofamulu.tieba.ch.a.a = 63;
                            com.mofamulu.tieba.ch.a.a();
                            arrayList.clear();
                        }
                    }
                    if (z && !c.z()) {
                        z = false;
                    }
                }
                int i5 = 0;
                String str4 = null;
                int i6 = -1;
                int i7 = -1;
                int i8 = i4;
                while (i5 < arrayList.size()) {
                    Object obj = arrayList.get(i5);
                    if (obj instanceof BasicNameValuePair) {
                        String name = ((BasicNameValuePair) obj).getName();
                        if ("_client_version".equals(name)) {
                            arrayList.remove(i5);
                            if (i8 == 1) {
                                str3 = "4.1.0";
                            } else if (i8 == 3) {
                                str3 = "1.0";
                            } else if (i8 == 4) {
                                str3 = "1.0.0";
                            } else {
                                str3 = "4.2.0";
                            }
                            arrayList.add(i5, new BasicNameValuePair(name, str3));
                            str2 = str4;
                            i = i6;
                            i2 = i7;
                            i3 = i8;
                        } else if ("_client_type".equals(name)) {
                            arrayList.remove(i5);
                            if (i8 == 5) {
                                arrayList.add(i5, new BasicNameValuePair(name, "0"));
                                str2 = str4;
                                i = i6;
                                i2 = i7;
                                i3 = i8;
                            } else {
                                int i9 = i8 > 5 ? i8 - 1 : i8;
                                arrayList.add(i5, new BasicNameValuePair(name, String.valueOf(i9)));
                                i = i6;
                                i3 = i9;
                                str2 = str4;
                                i2 = i7;
                            }
                        } else if (z) {
                            if (PushConstants.EXTRA_CONTENT.equals(name)) {
                                str2 = ((BasicNameValuePair) obj).getValue();
                                i = i6;
                                i2 = i5;
                                i3 = i8;
                            } else if ("floor_num".equals(name)) {
                                str2 = str4;
                                i = i5;
                                i3 = i8;
                                i2 = i7;
                            }
                        }
                        i5++;
                        i7 = i2;
                        i8 = i3;
                        str4 = str2;
                        i6 = i;
                    }
                    str2 = str4;
                    i = i6;
                    i2 = i7;
                    i3 = i8;
                    i5++;
                    i7 = i2;
                    i8 = i3;
                    str4 = str2;
                    i6 = i;
                }
                if (z && i7 > -1) {
                    if (i6 > -1) {
                        str = c.B();
                    } else {
                        str = an.b != null ? an.b.d : null;
                    }
                    if (str != null) {
                        if (!str.contains("#(") || c.e(false)) {
                            if (str.contains("@时间尾巴")) {
                                str = com.mofamulu.tieba.ch.ae.a(new Date(), str.replace("@时间尾巴", ""));
                            }
                            if (str.contains("@完整坐标尾巴") && (a3 = FreeLocationService.a(TiebaApplication.f())) != null) {
                                String f = a3.f();
                                if (f == null) {
                                    f = "";
                                }
                                str = str.replace("@完整坐标尾巴", f);
                            }
                            if (str.contains("@坐标尾巴") && (a2 = FreeLocationService.a(TiebaApplication.f())) != null) {
                                String g = a2.g();
                                if (g == null) {
                                    g = "";
                                }
                                str = str.replace("@坐标尾巴", g);
                            }
                            arrayList.remove(i7);
                            arrayList.add(i7, new BasicNameValuePair(PushConstants.EXTRA_CONTENT, String.valueOf(str4) + str));
                        }
                    }
                }
            }
        }
    }

    public static void a(ArrayList arrayList) {
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    Object obj = arrayList.get(i2);
                    if (obj instanceof BasicNameValuePair) {
                        String name = ((BasicNameValuePair) obj).getName();
                        if ("_client_version".equals(name)) {
                            arrayList.remove(i2);
                            arrayList.add(i2, new BasicNameValuePair(name, "4.2.0"));
                            return;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static boolean a(Object obj, HttpURLConnection httpURLConnection, String str, String str2, ArrayList arrayList, HashMap hashMap) {
        boolean z = false;
        if (arrayList == null) {
            Log.v("tbhp_net", "test_m no params. j=" + str);
        } else if (!arrayList.remove(a)) {
            try {
                bg c = bg.c();
                if ("http://c.tieba.baidu.com/c/s/sync".equals(str)) {
                    a(arrayList);
                    arrayList.add(a);
                    z = true;
                } else if (str.contains("c.tieba.baidu.com/c/s/apprecommend")) {
                    arrayList.add(a);
                    z = true;
                } else if (str.equals("http://c.tieba.baidu.com/c/s/tag/allthread")) {
                    a(arrayList, false);
                    if (c.I()) {
                        arrayList.add(a);
                        z = true;
                    }
                } else if (str.equals("http://c.tieba.baidu.com/c/f/pb/picpage")) {
                    a(arrayList, false);
                    if (c.I() && !c.K()) {
                        arrayList.add(a);
                        z = true;
                    }
                } else if (str.contains("http://c.tieba.baidu.com/c/s/msg") && c.M() && c.e(false)) {
                    a(arrayList, false);
                    arrayList.add(a);
                    z = true;
                } else if ("http://c.tieba.baidu.com/c/c/post/add".equals(str) || "http://c.tieba.baidu.com/c/c/thread/add".equals(str)) {
                    a(arrayList, true);
                } else {
                    a(arrayList, false);
                }
            } catch (Throwable th) {
                Log.e("tbhp_net", "unable to call test_m method", th);
            }
        }
        return z;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0067 -> B:32:0x0019). Please submit an issue!!! */
    public static String a(NetWorkCore netWorkCore, HttpURLConnection httpURLConnection, String str, String str2, ArrayList arrayList, HashMap hashMap) {
        String str3;
        if (str.contains("c.tieba.baidu.com/c/s/apprecommend")) {
            netWorkCore.a("http://book.mofamulu.com/api/android/apps_r.jsp");
        } else if (str.equals("http://c.tieba.baidu.com/c/f/pb/picpage")) {
            bg c = bg.c();
            if (c.I() && !c.K()) {
                return null;
            }
        }
        try {
            str3 = netWorkCore.o();
            if (bf.a(str3)) {
                str3 = null;
            } else if (str.equals("http://c.tieba.baidu.com/c/s/tag/allthread")) {
                str3 = bf.a(bf.a(bf.a(str3, "<img", "<blockimg"), "background:url(", "background2:url2("), "background-image:url(", "background2-image:url2(");
            } else if (str.equals("http://c.tieba.baidu.com/c/s/msg")) {
                com.mofamulu.tieba.ch.a.a(new am(netWorkCore, str3));
            } else if ("http://c.tieba.baidu.com/c/s/sync".equals(str)) {
                JSONObject jSONObject = new JSONObject(str3.trim());
                JSONObject jSONObject2 = jSONObject.getJSONObject("version");
                jSONObject2.put("force_update", "0");
                jSONObject2.put("new_version", "4.1.1");
                jSONObject2.put("new_version_url", "http://blog.sina.com.cn/s/blog_b1dffc3b01016ihk.html");
                jSONObject2.put("new_version_remind", "0");
                jSONObject2.put("new_version_desc", "");
                str3 = jSONObject.toString();
            }
        } catch (Throwable th) {
            Log.e("tbhp_net", "unable to call m method", th);
            str3 = "";
        }
        return str3;
    }

    public static boolean b(Object obj, HttpURLConnection httpURLConnection, String str, String str2, ArrayList arrayList, HashMap hashMap) {
        a(arrayList, false);
        return false;
    }

    public static String c(Object obj, HttpURLConnection httpURLConnection, String str, String str2, ArrayList arrayList, HashMap hashMap) {
        return "";
    }

    public static boolean d(Object obj, HttpURLConnection httpURLConnection, String str, String str2, ArrayList arrayList, HashMap hashMap) {
        a(arrayList, false);
        return false;
    }

    public static String e(Object obj, HttpURLConnection httpURLConnection, String str, String str2, ArrayList arrayList, HashMap hashMap) {
        return "";
    }

    public static boolean f(Object obj, HttpURLConnection httpURLConnection, String str, String str2, ArrayList arrayList, HashMap hashMap) {
        a(arrayList, false);
        if (str == null || !str.contains("cgi-bin")) {
            if (str == null) {
                return true;
            }
            bg c = bg.c();
            if (c.I()) {
                return (c.K() && com.mofamulu.tieba.dslv.lock.a.d) ? false : true;
            }
            return false;
        }
        return false;
    }

    public static byte[] g(Object obj, HttpURLConnection httpURLConnection, String str, String str2, ArrayList arrayList, HashMap hashMap) {
        return null;
    }
}
