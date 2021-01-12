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
/* loaded from: classes3.dex */
public final class j implements h {
    private static String java = "mraid";

    /* renamed from: a  reason: collision with root package name */
    private boolean f13750a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f13751b;
    private boolean c;

    /* renamed from: case  reason: not valid java name */
    private int f61case;

    /* renamed from: java  reason: collision with other field name */
    private int f62java;

    /* renamed from: java  reason: collision with other field name */
    private ag f63java;
    private boolean pYL;
    private y pZk;
    private boolean pZl;
    private y.Ccase pZm;

    public j(y yVar) {
        this.pZk = yVar;
    }

    @Override // com.win.opensdk.h
    public final boolean java() {
        return this.pYL;
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
        if (this.pZk != null && !this.pZl) {
            String str = this.pZk.getMraidMideaType() == af.BANNER ? "inline" : "interstitial";
            this.pYL = yVar.getMraidState().equals(ag.STATE_EXPANDED);
            g.e(yVar, "javascript:window.mraidbridge.setPlacementType('" + str + "')");
            if (!this.pYL) {
                if (this.pZk != null) {
                    boolean z2 = ax(new Intent("android.intent.action.VIEW", Uri.parse("sms:11035000")));
                    boolean z3 = ax(new Intent("android.intent.action.VIEW", Uri.parse("tel:11035000")));
                    if (Build.VERSION.SDK_INT >= 14) {
                        if (ax(new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI))) {
                            z = true;
                        } else if (ax(new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event"))) {
                            z = true;
                        }
                        boolean z4 = this.pZk.getContext().getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.pZk.getContext().getPackageName()) != 0 && Build.VERSION.SDK_INT >= 11;
                        boolean z5 = f((Activity) yVar.getViewContext(), yVar);
                        g.e(this.pZk, "javascript:window.mraidbridge.setSupports(" + z2 + "," + z3 + "," + z + "," + z4 + "," + z5 + ")");
                    }
                    z = false;
                    if (this.pZk.getContext().getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.pZk.getContext().getPackageName()) != 0) {
                    }
                    boolean z52 = f((Activity) yVar.getViewContext(), yVar);
                    g.e(this.pZk, "javascript:window.mraidbridge.setSupports(" + z2 + "," + z3 + "," + z + "," + z4 + "," + z52 + ")");
                }
                a();
                eGA();
                if (this.pZk != null) {
                    try {
                        int[] iArr2 = new int[2];
                        this.pZk.getLocationOnScreen(iArr2);
                        iArr2[1] = iArr2[1] - (this.pZk.getViewContext() instanceof Activity ? ((Activity) this.pZk.getViewContext()).getWindow().findViewById(16908290).getTop() : 0);
                        this.pZk.measure(0, 0);
                        bi.b(this.pZk.getViewContext(), new int[]{this.pZk.getMeasuredWidth(), this.pZk.getMeasuredHeight()});
                        g.e(this.pZk, "javascript:window.mraidbridge.setDefaultPosition(" + iArr2[0] + "," + iArr2[1] + "," + iArr[0] + "," + iArr[1] + ")");
                    } catch (Exception e) {
                    }
                }
            }
            this.pZk.eGz();
            a(yVar, yVar.getMraidState());
            g.e(yVar, "javascript:window.mraidbridge.notifyReadyEvent()");
            this.pZl = true;
            CC(this.pZk.java());
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
        if (this.pZk == null) {
            return false;
        }
        try {
            return this.pZk.getContext().getPackageManager().queryIntentActivities(intent, 0).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    private void CC(boolean z) {
        if (this.pZk != null && this.pZl) {
            this.f13750a = z;
            g.b(this.pZk, z);
        }
    }

    @Override // com.win.opensdk.h
    public final void S(int i, int i2, int i3, int i4) {
        if (this.pZk != null) {
            try {
                int[] iArr = new int[4];
                if (iArr[0] != i || iArr[1] != i2 || iArr[2] != i3 || iArr[3] != i4) {
                    iArr[0] = i;
                    iArr[1] = i2;
                    iArr[2] = i3;
                    iArr[3] = i4;
                    int[] iArr2 = {i, i2 - (this.pZk.getViewContext() instanceof Activity ? ((Activity) this.pZk.getViewContext()).getWindow().findViewById(16908290).getTop() : 0), i3, i4};
                    bi.b(this.pZk.getViewContext(), iArr2);
                    int i5 = iArr2[0];
                    int i6 = iArr2[1];
                    int i7 = iArr2[2];
                    int i8 = iArr2[3];
                    g.e(this.pZk, "javascript:window.mraidbridge.setCurrentPosition(" + i5 + "," + i6 + "," + i7 + "," + i8 + ")");
                    g.e(this.pZk, "javascript:window.mraidbridge.notifySizeChangeEvent(" + i7 + "," + i8 + ")");
                }
            } catch (Exception e) {
            }
        }
    }

    @Override // com.win.opensdk.h
    public final void eGz() {
        Activity activity;
        try {
            if (this.pZk != null) {
                if (this.f13751b || this.c || this.pYL) {
                    this.pZk.eGA();
                    a(this.pZk, ag.STATE_DEFAULT);
                    if (!this.pZk.eGX() && !this.pYL) {
                        this.pZk.getDispatcher().eGA();
                    }
                    if (!this.pZk.m79a() && !this.pYL) {
                        this.pZk.getDispatcher().eGA();
                    }
                    if ((this.pZk.getViewContext() instanceof Activity) && (activity = (Activity) this.pZk.getViewContext()) != null) {
                        activity.setRequestedOrientation(-1);
                    }
                    this.f13751b = false;
                    this.c = false;
                    this.pZm = null;
                } else if (this.pZk.eGX()) {
                    this.pZk.getDispatcher().eGA();
                } else if (this.pZk.m79a()) {
                    this.pZk.getDispatcher().eGA();
                } else {
                    y yVar = this.pZk;
                    if (yVar.getVisibility() == 8) {
                        return;
                    }
                    yVar.setVisibility(8);
                }
            }
        } catch (Exception e) {
        }
    }

    private void CD(boolean z) {
        if (this.pZk != null) {
            try {
                this.pZk.setMRAIDUseCustomClose(z);
            } catch (Exception e) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void bq(ArrayList<Pair<String, String>> arrayList) {
        DisplayMetrics displayMetrics;
        char c;
        String decode;
        if (this.pZk != null) {
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
                        this.pZm = new y.Ccase(this.pZk.getViewContext(), this.pZk.getMraidMideaType(), this);
                        this.pZm.loadUrl(str);
                    } catch (Exception e3) {
                    }
                } else {
                    y yVar = this.pZk;
                    ((WindowManager) yVar.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(yVar.getLayoutParams());
                    int i3 = i != -1 ? (int) ((i * displayMetrics.density) + 0.5d) : i;
                    int i4 = i2 != -1 ? (int) ((i2 * displayMetrics.density) + 0.5d) : i2;
                    layoutParams.height = i3;
                    layoutParams.width = i4;
                    layoutParams.gravity = 17;
                    yVar.setLayoutParams(layoutParams);
                }
                a(this.pZk, ag.STATE_EXPANDED);
                this.f13751b = true;
                CD(z);
                this.pZk.getDispatcher();
            } catch (Exception e4) {
            }
        }
    }

    @Override // com.win.opensdk.h
    public final boolean aaC(String str) {
        if (this.pZk == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.pZk.getDispatcher().aaC(str);
    }

    private void br(ArrayList<Pair<String, String>> arrayList) {
        if (this.pZk != null) {
            String str = null;
            Iterator<Pair<String, String>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                str = ((String) next.first).equals(DownloadDataConstants.Columns.COLUMN_URI) ? (String) next.second : str;
            }
            if (str != null) {
                final String decode = Uri.decode(str);
                AlertDialog.Builder builder = new AlertDialog.Builder(bi.ey(this.pZk));
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
                                    fileOutputStream.write(!z ? bc.aaJ(decode.substring(decode.lastIndexOf(",") + 1, decode.length())) : Base64.decode(decode.substring(decode.lastIndexOf(",") + 1, decode.length()), 0));
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
                                j.this.pZk.getDispatcher().aaC(null);
                            } catch (IOException e7) {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e8) {
                                    }
                                }
                                j.this.pZk.getDispatcher().aaC(null);
                            } catch (IllegalArgumentException e9) {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e10) {
                                    }
                                }
                                j.this.pZk.getDispatcher().aaC(null);
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
                            DownloadManager downloadManager = (DownloadManager) j.this.pZk.getContext().getSystemService("download");
                            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(decode));
                            if (j.this.pZk.getContext().getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", j.this.pZk.getContext().getPackageName()) == 0) {
                                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, decode.split("/")[decode.split("/").length - 1]);
                                try {
                                    request.allowScanningByMediaScanner();
                                    request.setNotificationVisibility(1);
                                    downloadManager.enqueue(request);
                                } catch (IllegalStateException e12) {
                                }
                            }
                        }
                        j.this.pZk.getDispatcher().aaC(null);
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
        if (this.pZk != null) {
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
                            i3 = aj.f13722a;
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
            if ((this.f13751b || this.pZk.eGX() || this.pZk.m79a()) && (this.pZk.getViewContext() instanceof Activity)) {
                Activity activity = (Activity) this.pZk.getViewContext();
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
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] java = new int[aj.java().length];

        static {
            try {
                java[aj.f13722a - 1] = 1;
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
        if (this.pZk != null) {
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
                y yVar = this.pZk;
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) yVar.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(yVar.getLayoutParams());
                float f = displayMetrics.density;
                layoutParams.height = (int) ((i * displayMetrics.density) + 0.5d);
                layoutParams.width = (int) ((f * i2) + 0.5d);
                layoutParams.gravity = 17;
                yVar.setLayoutParams(layoutParams);
                this.pZk.getDispatcher().aaC(null);
                a(this.pZk, ag.STATE_RESIZED);
                this.c = true;
                return;
            }
            g.e(this.pZk, "javascript:window.mraidbridge.notifyErrorEvent('Resize called with resizeProperties larger than the screen.','mraid.resize()')");
        }
    }

    private void a(y yVar, ag agVar) {
        g.d(yVar, agVar.toString());
        if (agVar != ag.STATE_EXPANDED) {
            if (this.f63java == ag.STATE_EXPANDED && agVar == ag.STATE_DEFAULT) {
                yVar.getDispatcher().eGA();
            } else if (agVar == ag.STATE_HIDDEN) {
                yVar.getDispatcher().eGA();
            }
        }
        this.f63java = agVar;
    }

    @Override // com.win.opensdk.h
    public final void eGA() {
        if (this.pZk != null) {
            try {
                int[] iX = bi.iX(this.pZk.getViewContext());
                int i = iX[0];
                int top = iX[1] - (this.pZk.getViewContext() instanceof Activity ? ((Activity) this.pZk.getViewContext()).getWindow().findViewById(16908290).getTop() : 0);
                float f = this.pZk.getViewContext().getResources().getDisplayMetrics().density;
                g.a(this.pZk, (int) ((i / f) + 0.5f), (int) ((top / f) + 0.5f));
            } catch (Exception e) {
            }
        }
    }

    @Override // com.win.opensdk.h
    public final void a() {
        if (this.pZk != null) {
            try {
                int[] iY = bi.iY(this.pZk.getViewContext());
                this.f62java = iY[0];
                this.f61case = iY[1];
                g.b(this.pZk, this.f62java, this.f61case);
            } catch (Exception e) {
            }
        }
    }

    @Override // com.win.opensdk.h
    public final void b() {
        boolean java2;
        if (this.pZk != null && this.f13750a != (java2 = this.pZk.java())) {
            CC(java2);
        }
    }

    @Override // com.win.opensdk.h
    public final void aaD(String str) {
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
                    eGz();
                } else if (!"createCalendarEvent".equals(host)) {
                    if ("expand".equals(host)) {
                        bq(arrayList);
                    } else if ("open".equals(host)) {
                        Iterator<Pair<String, String>> it = arrayList.iterator();
                        String str3 = null;
                        while (it.hasNext()) {
                            Pair<String, String> next = it.next();
                            str3 = ((String) next.first).equals("url") ? Uri.decode((String) next.second) : str3;
                        }
                        aaC(str3);
                    } else if (!"playVideo".equals(host)) {
                        if (ResizeImageAction.ACTION_NAME.equals(host)) {
                            b(arrayList);
                        } else if ("setOrientationProperties".equals(host)) {
                            a(arrayList);
                        } else if ("storePicture".equals(host)) {
                            br(arrayList);
                        } else if ("useCustomClose".equals(host)) {
                            CD(Boolean.parseBoolean((String) arrayList.get(0).second));
                        }
                    }
                } else if (this.pZk != null) {
                    if (Build.VERSION.SDK_INT < 14 || (!ax(new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI)) && !ax(new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event")))) {
                        z = false;
                    }
                    if (z) {
                        try {
                            o aaE = arrayList.size() > 0 ? o.aaE(URLDecoder.decode((String) arrayList.get(0).second, "UTF-8")) : null;
                            if (aaE != null) {
                                try {
                                    Intent eGB = aaE.eGB();
                                    eGB.setFlags(268435456);
                                    this.pZk.getContext().startActivity(eGB);
                                    this.pZk.getDispatcher().aaC(null);
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
