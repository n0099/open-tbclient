package com.win.opensdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.live.tbadk.img.effect.ResizeImageAction;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.win.opensdk.d;
import com.win.opensdk.views.MraidLayout;
import com.win.opensdk.y;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class j implements h {
    private static String java = "mraid";

    /* renamed from: a  reason: collision with root package name */
    private boolean f14049a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14050b;
    private boolean c;

    /* renamed from: case  reason: not valid java name */
    private int f61case;

    /* renamed from: java  reason: collision with other field name */
    private int f62java;

    /* renamed from: java  reason: collision with other field name */
    private ag f63java;
    private boolean qbE;
    private y qcd;
    private boolean qce;
    private y.Ccase qcf;

    public j(y yVar) {
        this.qcd = yVar;
    }

    @Override // com.win.opensdk.h
    public final boolean java() {
        return this.qbE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:14|(1:16)(1:42)|17|(1:19)(1:41)|20|(7:22|(1:24)(2:37|(1:39))|25|(1:36)(1:29)|30|31|32)|40|25|(1:27)|36|30|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01e8, code lost:
        r0 = false;
     */
    @Override // com.win.opensdk.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(y yVar) {
        int[] iArr;
        boolean z;
        if (this.qcd != null && !this.qce) {
            String str = this.qcd.getMraidMideaType() == af.BANNER ? "inline" : "interstitial";
            this.qbE = yVar.getMraidState().equals(ag.STATE_EXPANDED);
            g.e(yVar, "javascript:window.mraidbridge.setPlacementType('" + str + "')");
            if (!this.qbE) {
                if (this.qcd != null) {
                    boolean z2 = ax(new Intent("android.intent.action.VIEW", Uri.parse("sms:11035000")));
                    boolean z3 = ax(new Intent("android.intent.action.VIEW", Uri.parse("tel:11035000")));
                    if (Build.VERSION.SDK_INT >= 14) {
                        if (ax(new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI))) {
                            z = true;
                        } else if (ax(new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event"))) {
                            z = true;
                        }
                        boolean z4 = this.qcd.getContext().getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.qcd.getContext().getPackageName()) != 0 && Build.VERSION.SDK_INT >= 11;
                        boolean z5 = f((Activity) yVar.getViewContext(), yVar);
                        g.e(this.qcd, "javascript:window.mraidbridge.setSupports(" + z2 + "," + z3 + "," + z + "," + z4 + "," + z5 + ")");
                    }
                    z = false;
                    if (this.qcd.getContext().getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.qcd.getContext().getPackageName()) != 0) {
                    }
                    boolean z52 = f((Activity) yVar.getViewContext(), yVar);
                    g.e(this.qcd, "javascript:window.mraidbridge.setSupports(" + z2 + "," + z3 + "," + z + "," + z4 + "," + z52 + ")");
                }
                a();
                eJM();
                if (this.qcd != null) {
                    try {
                        int[] iArr2 = new int[2];
                        this.qcd.getLocationOnScreen(iArr2);
                        iArr2[1] = iArr2[1] - (this.qcd.getViewContext() instanceof Activity ? ((Activity) this.qcd.getViewContext()).getWindow().findViewById(16908290).getTop() : 0);
                        this.qcd.measure(0, 0);
                        bi.b(this.qcd.getViewContext(), new int[]{this.qcd.getMeasuredWidth(), this.qcd.getMeasuredHeight()});
                        g.e(this.qcd, "javascript:window.mraidbridge.setDefaultPosition(" + iArr2[0] + "," + iArr2[1] + "," + iArr[0] + "," + iArr[1] + ")");
                    } catch (Exception e) {
                    }
                }
            }
            this.qcd.eJL();
            a(yVar, yVar.getMraidState());
            g.e(yVar, "javascript:window.mraidbridge.notifyReadyEvent()");
            this.qce = true;
            CG(this.qcd.java());
        }
    }

    private static boolean f(@NonNull Activity activity, @NonNull View view) {
        while (view.isHardwareAccelerated() && (view.getLayerType() & 1) == 0) {
            if (view.getParent() instanceof View) {
                view = (View) view.getParent();
            } else {
                Window window = activity.getWindow();
                return (window == null || (window.getAttributes().flags & 16777216) == 0) ? false : true;
            }
        }
        return false;
    }

    private boolean ax(Intent intent) {
        if (this.qcd == null) {
            return false;
        }
        try {
            return this.qcd.getContext().getPackageManager().queryIntentActivities(intent, 0).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    private void CG(boolean z) {
        if (this.qcd != null && this.qce) {
            this.f14049a = z;
            g.b(this.qcd, z);
        }
    }

    @Override // com.win.opensdk.h
    public final void S(int i, int i2, int i3, int i4) {
        if (this.qcd != null) {
            try {
                int[] iArr = new int[4];
                if (iArr[0] != i || iArr[1] != i2 || iArr[2] != i3 || iArr[3] != i4) {
                    iArr[0] = i;
                    iArr[1] = i2;
                    iArr[2] = i3;
                    iArr[3] = i4;
                    int[] iArr2 = {i, i2 - (this.qcd.getViewContext() instanceof Activity ? ((Activity) this.qcd.getViewContext()).getWindow().findViewById(16908290).getTop() : 0), i3, i4};
                    bi.b(this.qcd.getViewContext(), iArr2);
                    int i5 = iArr2[0];
                    int i6 = iArr2[1];
                    int i7 = iArr2[2];
                    int i8 = iArr2[3];
                    g.e(this.qcd, "javascript:window.mraidbridge.setCurrentPosition(" + i5 + "," + i6 + "," + i7 + "," + i8 + ")");
                    g.e(this.qcd, "javascript:window.mraidbridge.notifySizeChangeEvent(" + i7 + "," + i8 + ")");
                }
            } catch (Exception e) {
            }
        }
    }

    @Override // com.win.opensdk.h
    public final void eJL() {
        Activity activity;
        try {
            if (this.qcd != null) {
                if (this.f14050b || this.c || this.qbE) {
                    this.qcd.eJM();
                    a(this.qcd, ag.STATE_DEFAULT);
                    if (!this.qcd.eKj() && !this.qbE) {
                        this.qcd.getDispatcher().eJM();
                    }
                    if (!this.qcd.m72a() && !this.qbE) {
                        this.qcd.getDispatcher().eJM();
                    }
                    if ((this.qcd.getViewContext() instanceof Activity) && (activity = (Activity) this.qcd.getViewContext()) != null) {
                        activity.setRequestedOrientation(-1);
                    }
                    this.f14050b = false;
                    this.c = false;
                    this.qcf = null;
                } else if (this.qcd.eKj()) {
                    this.qcd.getDispatcher().eJM();
                } else if (this.qcd.m72a()) {
                    this.qcd.getDispatcher().eJM();
                } else {
                    y yVar = this.qcd;
                    if (yVar.getVisibility() == 8) {
                        return;
                    }
                    yVar.setVisibility(8);
                }
            }
        } catch (Exception e) {
        }
    }

    private void CH(boolean z) {
        if (this.qcd != null) {
            try {
                this.qcd.setMRAIDUseCustomClose(z);
            } catch (Exception e) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void bv(ArrayList<Pair<String, String>> arrayList) {
        DisplayMetrics displayMetrics;
        char c;
        String decode;
        if (this.qcd != null) {
            String str = null;
            try {
                Iterator<Pair<String, String>> it = arrayList.iterator();
                boolean z = false;
                int i = -1;
                int i2 = -1;
                while (it.hasNext()) {
                    Pair<String, String> next = it.next();
                    String str2 = (String) next.first;
                    switch (str2.hashCode()) {
                        case -1221029593:
                            if (str2.equals("height")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 116079:
                            if (str2.equals("url")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 113126854:
                            if (str2.equals("width")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 462177683:
                            if (str2.equals("shouldUseCustomClose")) {
                                c = 2;
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
                            try {
                                i2 = Integer.parseInt((String) next.second);
                                continue;
                            } catch (NumberFormatException e) {
                            }
                        case 1:
                            try {
                                i = Integer.parseInt((String) next.second);
                                continue;
                            } catch (NumberFormatException e2) {
                            }
                        case 2:
                            z = Boolean.parseBoolean((String) next.second);
                            continue;
                        case 3:
                            decode = Uri.decode((String) next.second);
                            break;
                        default:
                            decode = str;
                            break;
                    }
                    str = decode;
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        this.qcf = new y.Ccase(this.qcd.getViewContext(), this.qcd.getMraidMideaType(), this);
                        this.qcf.loadUrl(str);
                    } catch (Exception e3) {
                    }
                } else {
                    y yVar = this.qcd;
                    ((WindowManager) yVar.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(yVar.getLayoutParams());
                    int i3 = i != -1 ? (int) ((i * displayMetrics.density) + 0.5d) : i;
                    int i4 = i2 != -1 ? (int) ((i2 * displayMetrics.density) + 0.5d) : i2;
                    layoutParams.height = i3;
                    layoutParams.width = i4;
                    layoutParams.gravity = 17;
                    yVar.setLayoutParams(layoutParams);
                }
                a(this.qcd, ag.STATE_EXPANDED);
                this.f14050b = true;
                CH(z);
                this.qcd.getDispatcher();
            } catch (Exception e4) {
            }
        }
    }

    @Override // com.win.opensdk.h
    public final boolean abJ(String str) {
        if (this.qcd == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.qcd.getDispatcher().abJ(str);
    }

    private void bw(ArrayList<Pair<String, String>> arrayList) {
        if (this.qcd != null) {
            String str = null;
            Iterator<Pair<String, String>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                str = ((String) next.first).equals(DownloadDataConstants.Columns.COLUMN_URI) ? (String) next.second : str;
            }
            if (str != null) {
                final String decode = Uri.decode(str);
                AlertDialog.Builder builder = new AlertDialog.Builder(bi.ey(this.qcd));
                builder.setTitle(d.e.store_picture_title);
                builder.setMessage(d.e.store_picture_message);
                builder.setPositiveButton(d.e.store_picture_accept, new DialogInterface.OnClickListener() { // from class: com.win.opensdk.j.1
                    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [461=5, 463=5, 468=5] */
                    @Override // android.content.DialogInterface.OnClickListener
                    @SuppressLint({"NewApi"})
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Throwable th;
                        FileOutputStream fileOutputStream;
                        FileOutputStream fileOutputStream2 = null;
                        if (decode.startsWith("data:")) {
                            String str2 = ".png";
                            if (decode.contains(DownloadConstants.MIMETYPE_GIF)) {
                                str2 = ".gif";
                            } else if (decode.contains("image/jpeg") || decode.contains("image/pjpeg")) {
                                str2 = ".jpg";
                            } else if (decode.contains("image/png")) {
                                str2 = ".png";
                            } else if (decode.contains("image/tiff")) {
                                str2 = ".tif";
                            } else if (decode.contains("image/svg+xml")) {
                                str2 = ".svg";
                            }
                            boolean z = decode.contains("base64");
                            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), System.currentTimeMillis() + str2);
                            try {
                                fileOutputStream = new FileOutputStream(file);
                            } catch (FileNotFoundException e) {
                                fileOutputStream = null;
                            } catch (IOException e2) {
                                fileOutputStream = null;
                            } catch (IllegalArgumentException e3) {
                                fileOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            try {
                                if (file.canWrite()) {
                                    fileOutputStream.write(!z ? bc.abQ(decode.substring(decode.lastIndexOf(",") + 1, decode.length())) : Base64.decode(decode.substring(decode.lastIndexOf(",") + 1, decode.length()), 0));
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                }
                            } catch (FileNotFoundException e5) {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e6) {
                                    }
                                }
                                j.this.qcd.getDispatcher().abJ(null);
                            } catch (IOException e7) {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e8) {
                                    }
                                }
                                j.this.qcd.getDispatcher().abJ(null);
                            } catch (IllegalArgumentException e9) {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e10) {
                                    }
                                }
                                j.this.qcd.getDispatcher().abJ(null);
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream2 = fileOutputStream;
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e11) {
                                    }
                                }
                                throw th;
                            }
                        } else {
                            DownloadManager downloadManager = (DownloadManager) j.this.qcd.getContext().getSystemService("download");
                            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(decode));
                            if (j.this.qcd.getContext().getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", j.this.qcd.getContext().getPackageName()) == 0) {
                                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, decode.split("/")[decode.split("/").length - 1]);
                                try {
                                    request.allowScanningByMediaScanner();
                                    request.setNotificationVisibility(1);
                                    downloadManager.enqueue(request);
                                } catch (IllegalStateException e12) {
                                }
                            }
                        }
                        j.this.qcd.getDispatcher().abJ(null);
                    }
                });
                builder.setNegativeButton(d.e.store_picture_decline, new DialogInterface.OnClickListener() { // from class: com.win.opensdk.j.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.create().show();
            }
        }
    }

    private void a(ArrayList<Pair<String, String>> arrayList) {
        boolean z;
        int i;
        if (this.qcd != null) {
            int i2 = aj.java;
            Iterator<Pair<String, String>> it = arrayList.iterator();
            int i3 = i2;
            boolean z2 = true;
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                if (((String) next.first).equals("allowOrientationChange")) {
                    z2 = Boolean.parseBoolean((String) next.second);
                } else {
                    if (((String) next.first).equals("forceOrientation")) {
                        String str = (String) next.second;
                        if (str.equals("landscape")) {
                            i3 = aj.f14021a;
                        } else if (str.equals("portrait")) {
                            i3 = aj.f19case;
                        } else {
                            i = aj.java;
                        }
                    } else {
                        i = i3;
                    }
                    i3 = i;
                }
            }
            if ((this.f14050b || this.qcd.eKj() || this.qcd.m72a()) && (this.qcd.getViewContext() instanceof Activity)) {
                Activity activity = (Activity) this.qcd.getViewContext();
                if (z2) {
                    activity.setRequestedOrientation(-1);
                    return;
                }
                switch (AnonymousClass3.java[i3 - 1]) {
                    case 1:
                        z = true;
                        break;
                    case 2:
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                if (activity != null && !activity.isFinishing()) {
                    int rotation = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRotation();
                    if (z) {
                        if (Build.VERSION.SDK_INT < 9) {
                            activity.setRequestedOrientation(1);
                        } else if (rotation == 2) {
                            activity.setRequestedOrientation(9);
                        } else {
                            activity.setRequestedOrientation(1);
                        }
                    } else if (z) {
                        if (Build.VERSION.SDK_INT < 9) {
                            activity.setRequestedOrientation(0);
                        } else if (rotation == 0 || rotation == 1) {
                            activity.setRequestedOrientation(0);
                        } else {
                            activity.setRequestedOrientation(8);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.win.opensdk.j$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] java = new int[aj.java().length];

        static {
            try {
                java[aj.f14021a - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                java[aj.f19case - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                java[aj.java - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void b(ArrayList<Pair<String, String>> arrayList) {
        char c;
        if (this.qcd != null) {
            Iterator<Pair<String, String>> it = arrayList.iterator();
            String str = "top-right";
            int i = -1;
            int i2 = -1;
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                try {
                    String str2 = (String) next.first;
                    switch (str2.hashCode()) {
                        case -1828291246:
                            if (str2.equals("allowOffscreen")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1705384112:
                            if (str2.equals("customClosePosition")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1548407259:
                            if (str2.equals("offsetX")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1548407258:
                            if (str2.equals("offsetY")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1221029593:
                            if (str2.equals("height")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 113126854:
                            if (str2.equals("width")) {
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
                            i2 = Integer.parseInt((String) next.second);
                            break;
                        case 1:
                            i = Integer.parseInt((String) next.second);
                            break;
                        case 2:
                            Integer.parseInt((String) next.second);
                            break;
                        case 3:
                            Integer.parseInt((String) next.second);
                            break;
                        case 4:
                            str = (String) next.second;
                            break;
                        case 5:
                            Boolean.parseBoolean((String) next.second);
                            break;
                    }
                } catch (NumberFormatException e) {
                    return;
                }
            }
            if (i2 <= this.f62java || i <= this.f61case) {
                MraidLayout.java javaVar = MraidLayout.java.TOP_RIGHT;
                try {
                    MraidLayout.java.valueOf(str.replace('-', '_'));
                } catch (IllegalArgumentException e2) {
                }
                y yVar = this.qcd;
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) yVar.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(yVar.getLayoutParams());
                float f = displayMetrics.density;
                layoutParams.height = (int) ((i * displayMetrics.density) + 0.5d);
                layoutParams.width = (int) ((f * i2) + 0.5d);
                layoutParams.gravity = 17;
                yVar.setLayoutParams(layoutParams);
                this.qcd.getDispatcher().abJ(null);
                a(this.qcd, ag.STATE_RESIZED);
                this.c = true;
                return;
            }
            g.e(this.qcd, "javascript:window.mraidbridge.notifyErrorEvent('Resize called with resizeProperties larger than the screen.','mraid.resize()')");
        }
    }

    private void a(y yVar, ag agVar) {
        g.d(yVar, agVar.toString());
        if (agVar != ag.STATE_EXPANDED) {
            if (this.f63java == ag.STATE_EXPANDED && agVar == ag.STATE_DEFAULT) {
                yVar.getDispatcher().eJM();
            } else if (agVar == ag.STATE_HIDDEN) {
                yVar.getDispatcher().eJM();
            }
        }
        this.f63java = agVar;
    }

    @Override // com.win.opensdk.h
    public final void eJM() {
        if (this.qcd != null) {
            try {
                int[] iZ = bi.iZ(this.qcd.getViewContext());
                int i = iZ[0];
                int top = iZ[1] - (this.qcd.getViewContext() instanceof Activity ? ((Activity) this.qcd.getViewContext()).getWindow().findViewById(16908290).getTop() : 0);
                float f = this.qcd.getViewContext().getResources().getDisplayMetrics().density;
                g.a(this.qcd, (int) ((i / f) + 0.5f), (int) ((top / f) + 0.5f));
            } catch (Exception e) {
            }
        }
    }

    @Override // com.win.opensdk.h
    public final void a() {
        if (this.qcd != null) {
            try {
                int[] ja = bi.ja(this.qcd.getViewContext());
                this.f62java = ja[0];
                this.f61case = ja[1];
                g.b(this.qcd, this.f62java, this.f61case);
            } catch (Exception e) {
            }
        }
    }

    @Override // com.win.opensdk.h
    public final void b() {
        boolean java2;
        if (this.qcd != null && this.f14049a != (java2 = this.qcd.java())) {
            CG(java2);
        }
    }

    @Override // com.win.opensdk.h
    public final void abK(String str) {
        boolean z = true;
        try {
            String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host)) {
                String[] split = str.split("\\?");
                ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
                if (split.length > 1) {
                    for (String str2 : str.substring(str.indexOf("?") + 1).split(ETAG.ITEM_SEPARATOR)) {
                        String[] split2 = str2.split("=");
                        if (split2.length >= 2 && !TextUtils.isEmpty(split2[1]) && !SessionMonitorEngine.PUBLIC_DATA_UNDIFNED.equals(split2[1])) {
                            arrayList.add(new Pair<>(split2[0], split2[1]));
                        }
                    }
                }
                if ("close".equals(host)) {
                    eJL();
                } else if (!"createCalendarEvent".equals(host)) {
                    if ("expand".equals(host)) {
                        bv(arrayList);
                    } else if ("open".equals(host)) {
                        Iterator<Pair<String, String>> it = arrayList.iterator();
                        String str3 = null;
                        while (it.hasNext()) {
                            Pair<String, String> next = it.next();
                            str3 = ((String) next.first).equals("url") ? Uri.decode((String) next.second) : str3;
                        }
                        abJ(str3);
                    } else if (!"playVideo".equals(host)) {
                        if (ResizeImageAction.ACTION_NAME.equals(host)) {
                            b(arrayList);
                        } else if ("setOrientationProperties".equals(host)) {
                            a(arrayList);
                        } else if ("storePicture".equals(host)) {
                            bw(arrayList);
                        } else if ("useCustomClose".equals(host)) {
                            CH(Boolean.parseBoolean((String) arrayList.get(0).second));
                        }
                    }
                } else if (this.qcd != null) {
                    if (Build.VERSION.SDK_INT < 14 || (!ax(new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI)) && !ax(new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event")))) {
                        z = false;
                    }
                    if (z) {
                        try {
                            o abL = arrayList.size() > 0 ? o.abL(URLDecoder.decode((String) arrayList.get(0).second, "UTF-8")) : null;
                            if (abL != null) {
                                try {
                                    Intent eJN = abL.eJN();
                                    eJN.setFlags(268435456);
                                    this.qcd.getContext().startActivity(eJN);
                                    this.qcd.getDispatcher().abJ(null);
                                } catch (ActivityNotFoundException e) {
                                }
                            }
                        } catch (UnsupportedEncodingException e2) {
                        }
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
