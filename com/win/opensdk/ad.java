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
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.live.tbadk.img.effect.ResizeImageAction;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.win.opensdk.bd;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes14.dex */
public class ad implements t {
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public B0 qkH;
    public L0 qkI;
    public C0 qkf;

    public ad(C0 c0) {
        this.qkf = c0;
    }

    public void a() {
        Activity activity;
        e eVar;
        try {
            if (this.qkf == null) {
                return;
            }
            if (!this.f && !this.g && !this.b) {
                if (this.qkf.d()) {
                    eVar = (e) this.qkf.getDispatcher();
                } else if (!this.qkf.f()) {
                    this.qkf.c();
                    return;
                } else {
                    eVar = (e) this.qkf.getDispatcher();
                }
                eVar.a();
                return;
            }
            this.qkf.b();
            a(this.qkf, L0.STATE_DEFAULT);
            if (!this.qkf.d() && !this.b) {
                ((e) this.qkf.getDispatcher()).a();
            }
            if (!this.qkf.f() && !this.b) {
                ((e) this.qkf.getDispatcher()).a();
            }
            if ((this.qkf.getViewContext() instanceof Activity) && (activity = (Activity) this.qkf.getViewContext()) != null) {
                activity.setRequestedOrientation(-1);
            }
            this.f = false;
            this.g = false;
            this.qkH = null;
        } catch (Exception e) {
        }
    }

    public void a(ArrayList arrayList) {
        au auVar = null;
        boolean z = false;
        if (this.qkf == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 14 && (a(new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI)) || a(new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event")))) {
            z = true;
        }
        if (z) {
            if (arrayList != null) {
                try {
                    if (arrayList.size() > 0) {
                        auVar = au.abZ(URLDecoder.decode((String) ((Pair) arrayList.get(0)).second, "UTF-8"));
                    }
                } catch (UnsupportedEncodingException e) {
                    return;
                }
            }
            if (auVar != null) {
                try {
                    Intent a2 = auVar.a();
                    a2.setFlags(268435456);
                    this.qkf.getContext().startActivity(a2);
                    ((e) this.qkf.getDispatcher()).a((String) null);
                } catch (ActivityNotFoundException e2) {
                }
            }
        }
    }

    public boolean a(Intent intent) {
        C0 c0 = this.qkf;
        if (c0 == null) {
            return false;
        }
        try {
            return c0.getContext().getPackageManager().queryIntentActivities(intent, 0).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean a(String str) {
        if (this.qkf == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return ((e) this.qkf.getDispatcher()).a(str);
    }

    public void b(ArrayList arrayList) {
        char c;
        if (this.qkf != null) {
            try {
                Iterator it = arrayList.iterator();
                String str = null;
                boolean z = false;
                int i = -1;
                int i2 = -1;
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    String str2 = (String) pair.first;
                    int hashCode = str2.hashCode();
                    if (hashCode == -1221029593) {
                        if (str2.equals("height")) {
                            c = 1;
                        }
                        c = 65535;
                    } else if (hashCode == 116079) {
                        if (str2.equals("url")) {
                            c = 3;
                        }
                        c = 65535;
                    } else if (hashCode == 113126854) {
                        if (str2.equals("width")) {
                            c = 0;
                        }
                        c = 65535;
                    } else if (hashCode != 462177683) {
                        c = 65535;
                    } else {
                        if (str2.equals("shouldUseCustomClose")) {
                            c = 2;
                        }
                        c = 65535;
                    }
                    switch (c) {
                        case 0:
                            try {
                                i2 = Integer.parseInt((String) pair.second);
                                break;
                            } catch (NumberFormatException e) {
                                break;
                            }
                        case 1:
                            i = Integer.parseInt((String) pair.second);
                            break;
                        case 2:
                            z = Boolean.parseBoolean((String) pair.second);
                            break;
                        case 3:
                            str = Uri.decode((String) pair.second);
                            break;
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    this.qkf.a(i2, i);
                } else {
                    try {
                        this.qkH = new B0(this.qkf.getViewContext(), this.qkf.getMraidMideaType(), this);
                        this.qkH.b(str);
                    } catch (Exception e2) {
                    }
                }
                a(this.qkf, L0.STATE_EXPANDED);
                this.f = true;
                C0 c0 = this.qkf;
                if (c0 != null) {
                    try {
                        c0.setMRAIDUseCustomClose(z);
                    } catch (Exception e3) {
                    }
                }
                ((e) this.qkf.getDispatcher()).a(this.qkH, z);
            } catch (Exception e4) {
            }
        }
    }

    public void bp(ArrayList arrayList) {
        Context context = null;
        if (this.qkf != null) {
            Iterator it = arrayList.iterator();
            String str = null;
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (((String) pair.first).equals(DownloadDataConstants.Columns.COLUMN_URI)) {
                    str = (String) pair.second;
                }
            }
            if (str != null) {
                String decode = Uri.decode(str);
                C0 c0 = this.qkf;
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
                builder.setTitle(bd.e.store_picture_title);
                builder.setMessage(bd.e.store_picture_message);
                builder.setPositiveButton(bd.e.store_picture_accept, new x(this, decode));
                builder.setNegativeButton(bd.e.store_picture_decline, new aa(this));
                builder.create().show();
            }
        }
    }

    public void a(String str, boolean z) {
        try {
            String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host)) {
                String[] split = str.split("\\?");
                ArrayList arrayList = new ArrayList();
                if (split.length > 1) {
                    for (String str2 : str.substring(str.indexOf("?") + 1).split(ETAG.ITEM_SEPARATOR)) {
                        String[] split2 = str2.split("=");
                        if (split2.length >= 2 && !TextUtils.isEmpty(split2[1]) && !SessionMonitorEngine.PUBLIC_DATA_UNDIFNED.equals(split2[1])) {
                            arrayList.add(new Pair(split2[0], split2[1]));
                        }
                    }
                }
                if ("close".equals(host)) {
                    a();
                } else if ("createCalendarEvent".equals(host)) {
                    a(arrayList);
                } else if ("expand".equals(host)) {
                    b(arrayList);
                } else if ("open".equals(host)) {
                    Iterator it = arrayList.iterator();
                    String str3 = null;
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        if (((String) pair.first).equals("url")) {
                            str3 = Uri.decode((String) pair.second);
                        }
                    }
                    a(str3);
                } else if (!"playVideo".equals(host)) {
                    if (ResizeImageAction.ACTION_NAME.equals(host)) {
                        c(arrayList);
                    } else if ("setOrientationProperties".equals(host)) {
                        bq(arrayList);
                    } else if ("storePicture".equals(host)) {
                        bp(arrayList);
                    } else if ("useCustomClose".equals(host)) {
                        boolean parseBoolean = Boolean.parseBoolean((String) ((Pair) arrayList.get(0)).second);
                        C0 c0 = this.qkf;
                        if (c0 != null) {
                            try {
                                c0.setMRAIDUseCustomClose(parseBoolean);
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(ArrayList arrayList) {
        char c;
        String str;
        if (this.qkf != null) {
            Iterator it = arrayList.iterator();
            String str2 = "top-right";
            int i = -1;
            int i2 = -1;
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                try {
                    String str3 = (String) pair.first;
                    switch (str3.hashCode()) {
                        case -1828291246:
                            if (str3.equals("allowOffscreen")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1705384112:
                            if (str3.equals("customClosePosition")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1548407259:
                            if (str3.equals("offsetX")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1548407258:
                            if (str3.equals("offsetY")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1221029593:
                            if (str3.equals("height")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 113126854:
                            if (str3.equals("width")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            i2 = Integer.parseInt((String) pair.second);
                            continue;
                        case 1:
                            i = Integer.parseInt((String) pair.second);
                            continue;
                        case 2:
                            str = (String) pair.second;
                            break;
                        case 3:
                            str = (String) pair.second;
                            break;
                        case 4:
                            str2 = (String) pair.second;
                            continue;
                        case 5:
                            Boolean.parseBoolean((String) pair.second);
                            continue;
                        default:
                            continue;
                    }
                    Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    return;
                }
            }
            if (i2 > this.h && i > this.i) {
                v.a(this.qkf, "javascript:window.mraidbridge.notifyErrorEvent('Resize called with resizeProperties larger than the screen.','mraid.resize()')");
                return;
            }
            u2 u2Var = u2.TOP_RIGHT;
            try {
                u2.valueOf(str2.replace('-', '_'));
            } catch (IllegalArgumentException e2) {
            }
            this.qkf.c(i2, i);
            ((e) this.qkf.getDispatcher()).a((String) null);
            a(this.qkf, L0.STATE_RESIZED);
            this.g = true;
        }
    }

    public final void a(C0 c0, L0 l0) {
        v.a(c0, "javascript:window.mraidbridge.setState('" + l0.f8097a + "')");
        L0 l02 = L0.STATE_EXPANDED;
        if (l0 != l02 && ((this.qkI == l02 && l0 == L0.STATE_DEFAULT) || l0 == L0.STATE_HIDDEN)) {
            ((e) c0.getDispatcher()).a();
        }
        this.qkI = l0;
    }

    public void b() {
        C0 c0 = this.qkf;
        if (c0 != null) {
            try {
                int[] iL = v.iL(c0.getViewContext());
                int i = iL[0];
                int top = iL[1] - (this.qkf.getViewContext() instanceof Activity ? ((Activity) this.qkf.getViewContext()).getWindow().findViewById(16908290).getTop() : 0);
                float f = this.qkf.getViewContext().getResources().getDisplayMetrics().density;
                v.a(this.qkf, "javascript:window.mraidbridge.setMaxSize(" + ((int) ((i / f) + 0.5f)) + "," + ((int) ((top / f) + 0.5f)) + ")");
            } catch (Exception e) {
            }
        }
    }

    public void bq(ArrayList arrayList) {
        if (this.qkf != null) {
            O0 o0 = O0.NONE;
            Iterator it = arrayList.iterator();
            O0 o02 = o0;
            boolean z = true;
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (((String) pair.first).equals("allowOrientationChange")) {
                    z = Boolean.parseBoolean((String) pair.second);
                } else if (((String) pair.first).equals("forceOrientation")) {
                    String str = (String) pair.second;
                    o02 = str.equals("landscape") ? O0.LANDSCAPE : str.equals("portrait") ? O0.PORTRAIT : O0.NONE;
                }
            }
            if ((this.f || this.qkf.d() || this.qkf.f()) && (this.qkf.getViewContext() instanceof Activity)) {
                Activity activity = (Activity) this.qkf.getViewContext();
                if (z) {
                    activity.setRequestedOrientation(-1);
                    return;
                }
                int ordinal = o02.ordinal();
                boolean z2 = ordinal != 1 ? ordinal != 2 ? false : true : true;
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                int rotation = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRotation();
                if (z2) {
                    if (Build.VERSION.SDK_INT >= 9 && rotation == 2) {
                        activity.setRequestedOrientation(9);
                    } else {
                        activity.setRequestedOrientation(1);
                    }
                } else if (z2) {
                    if (Build.VERSION.SDK_INT >= 9 && rotation != 0 && rotation != 1) {
                        activity.setRequestedOrientation(8);
                    } else {
                        activity.setRequestedOrientation(0);
                    }
                }
            }
        }
    }

    public void c() {
        C0 c0 = this.qkf;
        if (c0 != null) {
            try {
                Context viewContext = c0.getViewContext();
                int[] iL = v.iL(viewContext);
                v.b(viewContext, iL);
                this.h = iL[0];
                this.i = iL[1];
                C0 c02 = this.qkf;
                int i = this.h;
                v.a(c02, "javascript:window.mraidbridge.setScreenSize(" + i + "," + this.i + ")");
            } catch (Exception e) {
            }
        }
    }

    public void a(boolean z) {
        C0 c0 = this.qkf;
        if (c0 != null && this.c) {
            this.d = z;
            v.a(c0, "javascript:window.mraidbridge.setIsViewable(" + z + ")");
        }
    }
}
