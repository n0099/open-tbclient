package com.kascend.chushou.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.kascend.chushou.a;
import com.kascend.chushou.c.d;
import com.kascend.chushou.constants.AdTrackInfo;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.constants.Replacement;
import com.kascend.chushou.d.e;
import com.kascend.chushou.d.h;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.http.Http;
import tv.chushou.basis.http.model.RequestTag;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.widget.sweetalert.b;
/* loaded from: classes5.dex */
public class a {
    public List<C0716a> mnj;
    public final List<String> z = new ArrayList();
    public static String a = "10001";
    public static String b = "10002";
    public static String c = "10003";
    public static String d = "10004";
    public static String e = "10005";
    public static String f = "10006";
    public static String g = "10007";
    public static String h = "10008";
    public static String i = "10009";
    public static String j = "11001";
    public static String k = "10091";
    public static String l = "40001";
    public static String m = "40002";
    public static String n = "1";
    public static String o = "2";
    public static String p = "3";
    public static String q = "5";
    public static String r = "6";
    public static String s = "1";
    public static String t = "2";
    public static String u = "4";
    public static int v = 1;
    public static int w = 2;
    public static int x = 3;
    public static int y = 6;
    private static a mni = null;
    private static HashSet<Integer> mnk = new HashSet<>();
    private static String D = "";
    private static final RequestTag mnl = new RequestTag();

    /* loaded from: classes5.dex */
    public interface b {
        void a(ListItem listItem);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(List<ListItem> list);
    }

    static {
        mnl.supportEmpty = true;
        mnl.signType = 2;
        mnl.respType = String.class;
        mnl.thread = EventThread.IO;
        mnl.executorService = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0716a {
        String a;
        long b;
        long c;

        C0716a() {
        }
    }

    public static a dwE() {
        if (mni == null) {
            synchronized (a.class) {
                if (mni == null) {
                    mni = new a();
                }
            }
        }
        return mni;
    }

    private a() {
        String p2 = h.dwK().p();
        if (!tv.chushou.zues.utils.h.isEmpty(p2)) {
            try {
                this.mnj = (List) new Gson().fromJson(p2, new com.google.gson.b.a<List<C0716a>>() { // from class: com.kascend.chushou.a.a.1
                }.getType());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        mnk.clear();
        this.z.add(d);
        this.z.add(f);
        this.z.add(g);
        this.z.add(h);
        this.z.add(i);
        this.z.add(j);
        this.z.add(l);
        this.z.add(m);
    }

    public boolean a(String str, long j2) {
        return b(str, j2, true);
    }

    public boolean b(String str, long j2, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return false;
        }
        if (j2 <= 0) {
            j2 = 0;
        }
        if (this.mnj == null) {
            this.mnj = new ArrayList();
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mnj.size()) {
                C0716a c0716a = this.mnj.get(i3);
                if (!str.equals(c0716a.a)) {
                    i2 = i3 + 1;
                } else if (j2 == 0 && c0716a.b == 0) {
                    return true;
                } else {
                    if (j2 != c0716a.b) {
                        if (z) {
                            c0716a.b = j2;
                            c0716a.c = System.currentTimeMillis();
                            h.dwK().d(new Gson().toJson(this.mnj));
                        }
                        return true;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - c0716a.c < 0 || currentTimeMillis - c0716a.c > c0716a.b * 1000) {
                        if (z) {
                            c0716a.c = currentTimeMillis;
                            h.dwK().d(new Gson().toJson(this.mnj));
                        }
                        return true;
                    }
                    return false;
                }
            } else {
                if (z) {
                    C0716a c0716a2 = new C0716a();
                    c0716a2.b = j2;
                    c0716a2.c = System.currentTimeMillis();
                    c0716a2.a = str;
                    this.mnj.add(c0716a2);
                    h.dwK().d(new Gson().toJson(this.mnj));
                }
                return true;
            }
        }
    }

    public void a(String str, String str2, final c cVar) {
        if (!tv.chushou.zues.utils.h.isEmpty(str) && tv.chushou.basis.d.b.dJt() != null) {
            Point gh = tv.chushou.zues.utils.a.gh(tv.chushou.basis.d.b.dJt());
            com.kascend.chushou.c.c.dwG().a(str, String.valueOf(gh.x), String.valueOf(gh.y), str2, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.a.a.2
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str3, JSONObject jSONObject) {
                    ParserRet dy = d.dy(jSONObject);
                    if (dy.mRc == 0 && dy.mData != null) {
                        List<ListItem> list = (List) dy.mData;
                        if (cVar != null) {
                            cVar.a(list);
                            return;
                        }
                        return;
                    }
                    a(dy.mRc, dy.mMessage);
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str3) {
                    if (cVar != null) {
                        cVar.a(null);
                    }
                }
            });
        }
    }

    public void a(String str, String str2, final b bVar) {
        com.kascend.chushou.c.c.dwG().d(str, str2, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.a.a.3
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                ParserRet dC = d.dC(jSONObject);
                if (dC.mRc == 0 && dC.mData != null) {
                    ListItem listItem = (ListItem) dC.mData;
                    if (bVar != null) {
                        bVar.a(listItem);
                        return;
                    }
                    return;
                }
                a(dC.mRc, dC.mMessage);
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i2, String str3) {
                if (bVar != null) {
                    bVar.a(null);
                }
            }
        });
    }

    public static void a(final Context context, ListItem listItem, JSONObject jSONObject, boolean z) {
        if (listItem != null && listItem.mAdExtraInfo != null) {
            final ListItem listItem2 = (ListItem) listItem.deepCopy();
            if (z) {
                dwE().a(listItem2, jSONObject != null ? jSONObject.optInt("PLAY_DURATION", -1) : -1, jSONObject);
            }
            D = listItem2.mAdExtraInfo.mAdvertLink;
            if (!tv.chushou.zues.utils.h.isEmpty(D)) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                String optString = jSONObject.optString("__DOWN_X__", "-999");
                String optString2 = jSONObject.optString("__DOWN_Y__", "-999");
                String optString3 = jSONObject.optString("__UP_X__", "-999");
                String optString4 = jSONObject.optString("__UP_Y__", "-999");
                D = D.replace("__DOWN_X__", optString);
                D = D.replace("__DOWN_Y__", optString2);
                D = D.replace("__UP_X__", optString3);
                D = D.replace("__UP_Y__", optString4);
            }
            if (n.equals(listItem2.mAdExtraInfo.mActType)) {
                a(context, listItem2);
            } else if (o.equals(listItem2.mAdExtraInfo.mActType)) {
                if (!tv.chushou.zues.utils.h.isEmpty(D)) {
                    final int hashCode = listItem2.mAdExtraInfo.mAdvertLink.hashCode();
                    final File file = new File(com.kascend.chushou.d.c.mnC.dwH(), hashCode + ".apk");
                    new tv.chushou.zues.widget.sweetalert.b(context, 0).a(new b.a() { // from class: com.kascend.chushou.a.a.5
                        @Override // tv.chushou.zues.widget.sweetalert.b.a
                        public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                            bVar.dismiss();
                        }
                    }).b(new b.a() { // from class: com.kascend.chushou.a.a.4
                        @Override // tv.chushou.zues.widget.sweetalert.b.a
                        public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                            bVar.dismiss();
                            if (a.mnk.contains(Integer.valueOf(hashCode))) {
                                g.F(context, a.i.ad_down_exist_msg);
                                return;
                            }
                            if (file.exists()) {
                                file.delete();
                            }
                            a.mnk.add(Integer.valueOf(hashCode));
                            a.dwE().b(listItem2);
                            g.F(context, a.i.cs_confirm_download);
                        }
                    }).Qt(context.getString(a.i.cancel)).Qv(context.getString(a.i.cs_confirm)).Qs(context.getString(a.i.cs_info_title)).w(context.getString(a.i.cs_confirm_download)).show();
                }
            } else if (p.equals(listItem2.mAdExtraInfo.mActType)) {
                if (!tv.chushou.zues.utils.h.isEmpty(D)) {
                    a(D, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.a.a.6
                        @Override // com.kascend.chushou.c.b
                        public void a() {
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(String str, JSONObject jSONObject2) {
                            JSONObject jSONObject3;
                            if (tv.chushou.zues.utils.h.isEmpty(str)) {
                                a(-1, "");
                                return;
                            }
                            try {
                                jSONObject3 = new JSONObject(str);
                            } catch (JSONException e2) {
                                jSONObject3 = null;
                            }
                            if (jSONObject3 == null) {
                                a(-1, (String) null);
                                return;
                            }
                            int optInt = jSONObject3.optInt("ret", -1);
                            JSONObject optJSONObject = jSONObject3.optJSONObject("data");
                            if (optInt == 0 && optJSONObject != null) {
                                ListItem.this.mAdExtraInfo.mClickId = optJSONObject.optString("clickid");
                                ListItem.this.mAdExtraInfo.mAdvertLink = optJSONObject.optString("dstlink");
                                ListItem.this.mAdExtraInfo.mActType = a.o;
                                a.a(context, ListItem.this, null, false);
                                return;
                            }
                            a(optInt, "");
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(int i2, String str) {
                        }
                    }, new Object[0]);
                }
            } else if (q.equals(listItem2.mAdExtraInfo.mActType)) {
                ListItem listItem3 = (ListItem) listItem2.deepCopy();
                if (listItem3 != null) {
                    listItem3.mType = listItem2.mAdExtraInfo.mNavType;
                    e.a(context, listItem3, jSONObject);
                }
            } else if (r.equals(listItem2.mAdExtraInfo.mActType)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(listItem2.mAdExtraInfo.mAdvertDeepLink));
                if (tv.chushou.zues.utils.a.isIntentAvailable(context, intent)) {
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    return;
                }
                a(context, listItem2);
            }
        }
    }

    private static void a(Context context, ListItem listItem) {
        if (!tv.chushou.zues.utils.h.isEmpty(D)) {
            if (!listItem.mAdExtraInfo.mAdvertSelfOpen) {
                com.kascend.chushou.d.a.a(context, D, listItem.mName);
                return;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(D));
            if (tv.chushou.zues.utils.a.isIntentAvailable(context, intent)) {
                intent.setFlags(268435456);
                context.startActivity(intent);
                return;
            }
            com.kascend.chushou.d.a.a(context, D, listItem.mName);
        }
    }

    public void a(ListItem listItem) {
        String str;
        if (listItem != null && listItem.mAdExtraInfo != null && !tv.chushou.zues.utils.h.isEmpty(listItem.mAdExtraInfo.vTrack)) {
            for (int i2 = 0; i2 < listItem.mAdExtraInfo.vTrack.size(); i2++) {
                AdTrackInfo adTrackInfo = listItem.mAdExtraInfo.vTrack.get(i2);
                String str2 = adTrackInfo.mUrl;
                if (adTrackInfo.mReplacements != null) {
                    str = str2;
                    for (int i3 = 0; i3 < adTrackInfo.mReplacements.size(); i3++) {
                        Replacement replacement = adTrackInfo.mReplacements.get(i3);
                        if (replacement != null && !tv.chushou.zues.utils.h.isEmpty(replacement.mKeyword)) {
                            switch (replacement.mReplaceType) {
                                case 12:
                                    str = str.replace(replacement.mKeyword, String.valueOf(System.currentTimeMillis()));
                                    break;
                            }
                        }
                    }
                } else {
                    str = str2;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(str)) {
                    if (v == adTrackInfo.mSource) {
                        com.kascend.chushou.c.c.dwG().a(adTrackInfo.mUrl);
                    } else {
                        a(adTrackInfo.mUrl, (com.kascend.chushou.c.b) null, new Object[0]);
                    }
                }
            }
        }
    }

    public void a(ListItem listItem, int i2, JSONObject jSONObject) {
        String str;
        if (listItem != null && listItem.mAdExtraInfo != null && !tv.chushou.zues.utils.h.isEmpty(listItem.mAdExtraInfo.cTrack)) {
            for (int i3 = 0; i3 < listItem.mAdExtraInfo.cTrack.size(); i3++) {
                AdTrackInfo adTrackInfo = listItem.mAdExtraInfo.cTrack.get(i3);
                if (!tv.chushou.zues.utils.h.isEmpty(adTrackInfo.mUrl)) {
                    String str2 = adTrackInfo.mUrl;
                    if (adTrackInfo.mReplacements != null) {
                        str = str2;
                        for (int i4 = 0; i4 < adTrackInfo.mReplacements.size(); i4++) {
                            Replacement replacement = adTrackInfo.mReplacements.get(i4);
                            if (replacement != null && !tv.chushou.zues.utils.h.isEmpty(replacement.mKeyword)) {
                                if (jSONObject == null) {
                                    jSONObject = new JSONObject();
                                }
                                switch (replacement.mReplaceType) {
                                    case 1:
                                        str = str.replace(replacement.mKeyword, String.valueOf(i2));
                                        break;
                                    case 2:
                                        str = str.replace(replacement.mKeyword, jSONObject.optString("__DOWN_X__", "-999"));
                                        break;
                                    case 3:
                                        str = str.replace(replacement.mKeyword, jSONObject.optString("__DOWN_Y__", "-999"));
                                        break;
                                    case 4:
                                        str = str.replace(replacement.mKeyword, jSONObject.optString("__UP_X__", "-999"));
                                        break;
                                    case 5:
                                        str = str.replace(replacement.mKeyword, jSONObject.optString("__UP_Y__", "-999"));
                                        break;
                                    case 12:
                                        str = str.replace(replacement.mKeyword, String.valueOf(System.currentTimeMillis()));
                                        break;
                                    case 13:
                                        str = str.replace(replacement.mKeyword, jSONObject.optString("__DOWN_X__", "-999"));
                                        break;
                                    case 14:
                                        str = str.replace(replacement.mKeyword, jSONObject.optString("__DOWN_Y__", "-999"));
                                        break;
                                }
                            }
                        }
                    } else {
                        str = str2;
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(str)) {
                        if (v == adTrackInfo.mSource) {
                            com.kascend.chushou.c.c.dwG().a(str);
                        } else {
                            a(str, (com.kascend.chushou.c.b) null, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    public void b(ListItem listItem) {
        String str;
        if (listItem != null && listItem.mAdExtraInfo != null && !tv.chushou.zues.utils.h.isEmpty(listItem.mAdExtraInfo.dTrack)) {
            for (int i2 = 0; i2 < listItem.mAdExtraInfo.dTrack.size(); i2++) {
                AdTrackInfo adTrackInfo = listItem.mAdExtraInfo.dTrack.get(i2);
                if (!tv.chushou.zues.utils.h.isEmpty(adTrackInfo.mUrl)) {
                    String str2 = adTrackInfo.mUrl;
                    if (adTrackInfo.mReplacements != null) {
                        str = str2;
                        for (int i3 = 0; i3 < adTrackInfo.mReplacements.size(); i3++) {
                            Replacement replacement = adTrackInfo.mReplacements.get(i3);
                            if (replacement != null && !tv.chushou.zues.utils.h.isEmpty(replacement.mKeyword)) {
                                switch (replacement.mReplaceType) {
                                    case 6:
                                        if (tv.chushou.zues.utils.h.isEmpty(listItem.mAdExtraInfo.mClickId)) {
                                            break;
                                        } else {
                                            str = str.replace(replacement.mKeyword, listItem.mAdExtraInfo.mClickId);
                                            break;
                                        }
                                    case 12:
                                        str = str.replace(replacement.mKeyword, String.valueOf(System.currentTimeMillis()));
                                        break;
                                }
                            }
                        }
                    } else {
                        str = str2;
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(str)) {
                        if (v == adTrackInfo.mSource) {
                            com.kascend.chushou.c.c.dwG().a(str);
                        } else {
                            a(str, (com.kascend.chushou.c.b) null, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    public void c(ListItem listItem) {
        a(listItem, 0);
    }

    public void a(ListItem listItem, int i2) {
        String str;
        if (listItem != null && listItem.mAdExtraInfo != null && !tv.chushou.zues.utils.h.isEmpty(listItem.mAdExtraInfo.clTrack)) {
            for (int i3 = 0; i3 < listItem.mAdExtraInfo.clTrack.size(); i3++) {
                AdTrackInfo adTrackInfo = listItem.mAdExtraInfo.clTrack.get(i3);
                if (!tv.chushou.zues.utils.h.isEmpty(adTrackInfo.mUrl)) {
                    String str2 = adTrackInfo.mUrl;
                    if (adTrackInfo.mReplacements != null) {
                        str = str2;
                        for (int i4 = 0; i4 < adTrackInfo.mReplacements.size(); i4++) {
                            Replacement replacement = adTrackInfo.mReplacements.get(i4);
                            if (replacement != null && !tv.chushou.zues.utils.h.isEmpty(replacement.mKeyword)) {
                                switch (replacement.mReplaceType) {
                                    case 1:
                                        str = str.replace(replacement.mKeyword, String.valueOf(i2));
                                        break;
                                    case 12:
                                        str = str.replace(replacement.mKeyword, String.valueOf(System.currentTimeMillis()));
                                        break;
                                }
                            }
                        }
                    } else {
                        str = str2;
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(str)) {
                        if (v == adTrackInfo.mSource) {
                            com.kascend.chushou.c.c.dwG().a(str);
                        } else {
                            a(str, (com.kascend.chushou.c.b) null, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    public int a(ListItem listItem, View view, int i2, int i3, int i4) {
        if (listItem == null || listItem.mAdExtraInfo == null) {
            return 0;
        }
        if (listItem.mAdExtraInfo.mAdvertWidth <= 0 || listItem.mAdExtraInfo.mAdvertHeight <= 0 || view == null) {
            return 0;
        }
        int i5 = (listItem.mAdExtraInfo.mAdvertHeight * i2) / listItem.mAdExtraInfo.mAdvertWidth;
        if (i5 <= i3) {
            i3 = i5 < i4 ? i4 : i5;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i3;
        layoutParams.width = i2;
        view.setLayoutParams(layoutParams);
        return i3;
    }

    public int b(ListItem listItem, View view, int i2, int i3, int i4) {
        if (listItem == null || listItem.mAdExtraInfo == null) {
            return 0;
        }
        if (listItem.mAdExtraInfo.mAdvertWidth <= 0 || listItem.mAdExtraInfo.mAdvertHeight <= 0 || view == null) {
            return 0;
        }
        int i5 = (listItem.mAdExtraInfo.mAdvertWidth * i2) / listItem.mAdExtraInfo.mAdvertHeight;
        if (i5 <= i3) {
            i3 = i2 < i4 ? i4 : i5;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i3;
        view.setLayoutParams(layoutParams);
        return i3;
    }

    private static void a(String str, final com.kascend.chushou.c.b bVar, Object... objArr) {
        Http http = (Http) tv.chushou.basis.d.b.dJv().S(Http.class);
        if (http != null) {
            HashMap hashMap = new HashMap();
            if (objArr != null) {
                if (objArr.length % 2 != 0) {
                    throw new IllegalArgumentException("Supplied arguments must be even");
                }
                for (int i2 = 0; i2 < objArr.length; i2 += 2) {
                    hashMap.put(String.valueOf(objArr[i2]), objArr[i2 + 1]);
                }
            }
            http.getAsync(str, "", hashMap, mnl, new tv.chushou.basis.d.a.c.a<Http.Resp>() { // from class: com.kascend.chushou.a.a.7
                @Override // tv.chushou.basis.d.a.c.a
                public void onStart() {
                    if (com.kascend.chushou.c.b.this != null) {
                        com.kascend.chushou.c.b.this.a();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.basis.d.a.c.a
                /* renamed from: a */
                public void onSuccess(Http.Resp resp) {
                    if (resp != null && resp.respString != null && com.kascend.chushou.c.b.this != null) {
                        com.kascend.chushou.c.b.this.a(resp.respString, (JSONObject) null);
                    } else {
                        onFailure(-1, "", null);
                    }
                }

                @Override // tv.chushou.basis.d.a.c.a
                public void onFailure(int i3, @Nullable String str2, @Nullable Throwable th) {
                    if (com.kascend.chushou.c.b.this != null) {
                        com.kascend.chushou.c.b.this.a(i3, str2);
                    }
                }
            });
        }
    }
}
