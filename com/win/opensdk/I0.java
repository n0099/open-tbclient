package com.win.opensdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import com.alibaba.fastjson.asm.Label;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class I0 implements F0 {

    /* renamed from: a  reason: collision with root package name */
    public C0 f40063a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40064b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40065c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40066d;

    /* renamed from: e  reason: collision with root package name */
    public B0 f40067e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40068f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40069g;

    /* renamed from: h  reason: collision with root package name */
    public int f40070h;
    public int i;
    public L0 j;

    public I0(C0 c0) {
        this.f40063a = c0;
    }

    public void a() {
        Activity activity;
        C0 c0;
        try {
            if (this.f40063a == null) {
                return;
            }
            if (!this.f40068f && !this.f40069g && !this.f40064b) {
                if (this.f40063a.d()) {
                    c0 = this.f40063a;
                } else if (!this.f40063a.f()) {
                    this.f40063a.c();
                    return;
                } else {
                    c0 = this.f40063a;
                }
                ((A0) c0.getDispatcher()).a();
                return;
            }
            this.f40063a.b();
            a(this.f40063a, L0.STATE_DEFAULT);
            if (!this.f40063a.d() && !this.f40064b) {
                ((A0) this.f40063a.getDispatcher()).a();
            }
            if (!this.f40063a.f() && !this.f40064b) {
                ((A0) this.f40063a.getDispatcher()).a();
            }
            if ((this.f40063a.getViewContext() instanceof Activity) && (activity = (Activity) this.f40063a.getViewContext()) != null) {
                activity.setRequestedOrientation(-1);
            }
            this.f40068f = false;
            this.f40069g = false;
            this.f40067e = null;
        } catch (Exception unused) {
        }
    }

    public void a(String str, boolean z) {
        String host;
        try {
            host = Uri.parse(str).getHost();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(host)) {
            return;
        }
        String[] split = str.split("\\?");
        ArrayList arrayList = new ArrayList();
        if (split.length > 1) {
            for (String str2 : str.substring(str.indexOf("?") + 1).split("&")) {
                String[] split2 = str2.split("=");
                if (split2.length >= 2 && !TextUtils.isEmpty(split2[1]) && !SessionMonitorEngine.PUBLIC_DATA_UNDIFNED.equals(split2[1])) {
                    arrayList.add(new Pair(split2[0], split2[1]));
                }
            }
        }
        if (IntentConfig.CLOSE.equals(host)) {
            a();
        } else if ("createCalendarEvent".equals(host)) {
            a(arrayList);
        } else if ("expand".equals(host)) {
            b(arrayList);
        } else if ("open".equals(host)) {
            String str3 = null;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (((String) pair.first).equals("url")) {
                    str3 = Uri.decode((String) pair.second);
                }
            }
            a(str3);
        } else if (!"playVideo".equals(host)) {
            if ("resize".equals(host)) {
                c(arrayList);
            } else if ("setOrientationProperties".equals(host)) {
                d(arrayList);
            } else if ("storePicture".equals(host)) {
                e(arrayList);
            } else if ("useCustomClose".equals(host)) {
                boolean parseBoolean = Boolean.parseBoolean((String) ((Pair) arrayList.get(0)).second);
                C0 c0 = this.f40063a;
                if (c0 != null) {
                    try {
                        c0.setMRAIDUseCustomClose(parseBoolean);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ArrayList arrayList) {
        P0 b2;
        if (this.f40063a == null) {
            return;
        }
        if (!(Build.VERSION.SDK_INT >= 14 && (a(new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI)) || a(new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event"))))) {
            return;
        }
        if (arrayList != null) {
            try {
                if (arrayList.size() > 0) {
                    b2 = P0.b(URLDecoder.decode((String) ((Pair) arrayList.get(0)).second, "UTF-8"));
                    if (b2 == null) {
                        try {
                            Intent a2 = b2.a();
                            a2.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                            this.f40063a.getContext().startActivity(a2);
                            ((A0) this.f40063a.getDispatcher()).a((String) null);
                            return;
                        } catch (ActivityNotFoundException unused) {
                            return;
                        }
                    }
                    return;
                }
            } catch (UnsupportedEncodingException unused2) {
                return;
            }
        }
        b2 = null;
        if (b2 == null) {
        }
    }

    public boolean a(Intent intent) {
        C0 c0 = this.f40063a;
        if (c0 == null) {
            return false;
        }
        try {
            return c0.getContext().getPackageManager().queryIntentActivities(intent, 0).size() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean a(String str) {
        if (this.f40063a == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return ((A0) this.f40063a.getDispatcher()).a(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0066 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(ArrayList arrayList) {
        char c2;
        if (this.f40063a == null) {
            return;
        }
        String str = null;
        try {
            Iterator it = arrayList.iterator();
            int i = -1;
            int i2 = -1;
            boolean z = false;
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                String str2 = (String) pair.first;
                int hashCode = str2.hashCode();
                if (hashCode == -1221029593) {
                    if (str2.equals("height")) {
                        c2 = 1;
                        if (c2 != 0) {
                        }
                    }
                    c2 = 65535;
                    if (c2 != 0) {
                    }
                } else if (hashCode == 116079) {
                    if (str2.equals("url")) {
                        c2 = 3;
                        if (c2 != 0) {
                        }
                    }
                    c2 = 65535;
                    if (c2 != 0) {
                    }
                } else if (hashCode != 113126854) {
                    if (hashCode == 462177683 && str2.equals("shouldUseCustomClose")) {
                        c2 = 2;
                        if (c2 != 0) {
                            i = Integer.parseInt((String) pair.second);
                        } else if (c2 == 1) {
                            try {
                                i2 = Integer.parseInt((String) pair.second);
                            } catch (NumberFormatException unused) {
                            }
                        } else if (c2 == 2) {
                            z = Boolean.parseBoolean((String) pair.second);
                        } else if (c2 == 3) {
                            str = Uri.decode((String) pair.second);
                        }
                    }
                    c2 = 65535;
                    if (c2 != 0) {
                    }
                } else {
                    if (str2.equals("width")) {
                        c2 = 0;
                        if (c2 != 0) {
                        }
                    }
                    c2 = 65535;
                    if (c2 != 0) {
                    }
                }
            }
            if (TextUtils.isEmpty(str)) {
                this.f40063a.a(i, i2);
            } else {
                try {
                    B0 b0 = new B0(this.f40063a.getViewContext(), this.f40063a.getMraidMideaType(), this);
                    this.f40067e = b0;
                    b0.b(str);
                } catch (Exception unused2) {
                }
            }
            a(this.f40063a, L0.STATE_EXPANDED);
            this.f40068f = true;
            C0 c0 = this.f40063a;
            if (c0 != null) {
                try {
                    c0.setMRAIDUseCustomClose(z);
                } catch (Exception unused3) {
                }
            }
            ((A0) this.f40063a.getDispatcher()).a(this.f40067e, z);
        } catch (Exception unused4) {
        }
    }

    public void c(ArrayList arrayList) {
        char c2;
        if (this.f40063a == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        String str = "top-right";
        int i = -1;
        int i2 = -1;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            try {
                String str2 = (String) pair.first;
                switch (str2.hashCode()) {
                    case -1828291246:
                        if (str2.equals("allowOffscreen")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1705384112:
                        if (str2.equals("customClosePosition")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1548407259:
                        if (str2.equals("offsetX")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1548407258:
                        if (str2.equals("offsetY")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1221029593:
                        if (str2.equals("height")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 113126854:
                        if (str2.equals("width")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    i = Integer.parseInt((String) pair.second);
                } else if (c2 == 1) {
                    i2 = Integer.parseInt((String) pair.second);
                } else if (c2 == 2 || c2 == 3) {
                    Integer.parseInt((String) pair.second);
                } else if (c2 == 4) {
                    str = (String) pair.second;
                } else if (c2 == 5) {
                    Boolean.parseBoolean((String) pair.second);
                }
            } catch (NumberFormatException unused) {
                return;
            }
        }
        if (i > this.f40070h && i2 > this.i) {
            C0 c0 = this.f40063a;
            G.a(c0, "javascript:window.mraidbridge.notifyErrorEvent('Resize called with resizeProperties larger than the screen.','mraid.resize()')");
            return;
        }
        u2 u2Var = u2.TOP_RIGHT;
        try {
            u2.valueOf(str.replace('-', '_'));
        } catch (IllegalArgumentException unused2) {
        }
        this.f40063a.c(i, i2);
        ((A0) this.f40063a.getDispatcher()).a((String) null);
        a(this.f40063a, L0.STATE_RESIZED);
        this.f40069g = true;
    }

    public void d(ArrayList arrayList) {
        if (this.f40063a == null) {
            return;
        }
        O0 o0 = O0.NONE;
        Iterator it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (((String) pair.first).equals("allowOrientationChange")) {
                z = Boolean.parseBoolean((String) pair.second);
            } else if (((String) pair.first).equals("forceOrientation")) {
                String str = (String) pair.second;
                o0 = str.equals("landscape") ? O0.LANDSCAPE : str.equals("portrait") ? O0.PORTRAIT : O0.NONE;
            }
        }
        if ((this.f40068f || this.f40063a.d() || this.f40063a.f()) && (this.f40063a.getViewContext() instanceof Activity)) {
            Activity activity = (Activity) this.f40063a.getViewContext();
            if (z) {
                activity.setRequestedOrientation(-1);
                return;
            }
            int ordinal = o0.ordinal();
            char c2 = ordinal != 1 ? ordinal != 2 ? (char) 0 : (char) 2 : (char) 1;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            int rotation = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRotation();
            if (c2 == 1) {
                if (Build.VERSION.SDK_INT >= 9 && rotation == 2) {
                    activity.setRequestedOrientation(9);
                } else {
                    activity.setRequestedOrientation(1);
                }
            } else if (c2 == 2) {
                if (Build.VERSION.SDK_INT < 9 || rotation == 0 || rotation == 1) {
                    activity.setRequestedOrientation(0);
                } else {
                    activity.setRequestedOrientation(8);
                }
            }
        }
    }

    public void e(ArrayList arrayList) {
        if (this.f40063a == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        Context context = null;
        String str = null;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (((String) pair.first).equals("uri")) {
                str = (String) pair.second;
            }
        }
        if (str == null) {
            return;
        }
        String decode = Uri.decode(str);
        C0 c0 = this.f40063a;
        if (c0 != null) {
            ViewParent parent = c0.getParent();
            if (parent == null || !(parent instanceof View)) {
                context = c0.getContext() instanceof MutableContextWrapper ? ((MutableContextWrapper) c0.getContext()).getBaseContext() : c0.getContext();
            } else {
                while (parent.getParent() != null && (parent.getParent() instanceof View)) {
                    parent = parent.getParent();
                }
                context = ((View) parent).getContext();
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.store_picture_title);
        builder.setMessage(R.string.store_picture_message);
        builder.setPositiveButton(R.string.store_picture_accept, new G0(this, decode));
        builder.setNegativeButton(R.string.store_picture_decline, new H0(this));
        builder.create().show();
    }

    public void b() {
        C0 c0 = this.f40063a;
        if (c0 == null) {
            return;
        }
        try {
            int[] d2 = G.d(c0.getViewContext());
            int i = d2[0];
            int top = d2[1] - (this.f40063a.getViewContext() instanceof Activity ? ((Activity) this.f40063a.getViewContext()).getWindow().findViewById(16908290).getTop() : 0);
            float f2 = this.f40063a.getViewContext().getResources().getDisplayMetrics().density;
            int i2 = (int) ((i / f2) + 0.5f);
            C0 c02 = this.f40063a;
            G.a(c02, "javascript:window.mraidbridge.setMaxSize(" + i2 + "," + ((int) ((top / f2) + 0.5f)) + SmallTailInfo.EMOTION_SUFFIX);
        } catch (Exception unused) {
        }
    }

    public final void a(C0 c0, L0 l0) {
        String str = l0.f40105a;
        G.a(c0, "javascript:window.mraidbridge.setState('" + str + "')");
        L0 l02 = L0.STATE_EXPANDED;
        if (l0 != l02 && ((this.j == l02 && l0 == L0.STATE_DEFAULT) || l0 == L0.STATE_HIDDEN)) {
            ((A0) c0.getDispatcher()).a();
        }
        this.j = l0;
    }

    public void c() {
        C0 c0 = this.f40063a;
        if (c0 == null) {
            return;
        }
        try {
            Context viewContext = c0.getViewContext();
            int[] d2 = G.d(viewContext);
            G.a(viewContext, d2);
            int i = d2[0];
            this.f40070h = i;
            int i2 = d2[1];
            this.i = i2;
            C0 c02 = this.f40063a;
            G.a(c02, "javascript:window.mraidbridge.setScreenSize(" + i + "," + i2 + SmallTailInfo.EMOTION_SUFFIX);
        } catch (Exception unused) {
        }
    }

    public void a(boolean z) {
        C0 c0 = this.f40063a;
        if (c0 != null && this.f40065c) {
            this.f40066d = z;
            G.a(c0, "javascript:window.mraidbridge.setIsViewable(" + z + SmallTailInfo.EMOTION_SUFFIX);
        }
    }
}
