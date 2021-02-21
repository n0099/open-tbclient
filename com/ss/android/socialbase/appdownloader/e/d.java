package com.ss.android.socialbase.appdownloader.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.ss.android.socialbase.appdownloader.c.o;
import com.ss.android.socialbase.appdownloader.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13039a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static List<o> f13040b = new ArrayList();
    private static AlertDialog d;
    private static com.ss.android.socialbase.appdownloader.view.a qeg;

    public static boolean a() {
        try {
            return NotificationManagerCompat.from(com.ss.android.socialbase.downloader.downloader.b.eGC()).areNotificationsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (d.class) {
            try {
                if (d != null) {
                    d.cancel();
                    d = null;
                }
                for (o oVar : f13040b) {
                    if (oVar != null) {
                        if (z) {
                            oVar.a();
                        } else {
                            oVar.b();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized void a(@NonNull final Activity activity, @NonNull final o oVar) {
        synchronized (d.class) {
            if (oVar != null) {
                if (activity != null) {
                    try {
                        if (!activity.isFinishing()) {
                            int a2 = i.a(com.ss.android.socialbase.downloader.downloader.b.eGC(), "appdownloader_notification_request_title");
                            int a3 = i.a(com.ss.android.socialbase.downloader.downloader.b.eGC(), "appdownloader_notification_request_message");
                            int a4 = i.a(com.ss.android.socialbase.downloader.downloader.b.eGC(), "appdownloader_notification_request_btn_yes");
                            int a5 = i.a(com.ss.android.socialbase.downloader.downloader.b.eGC(), "appdownloader_notification_request_btn_no");
                            f13040b.add(oVar);
                            if (d == null || !d.isShowing()) {
                                d = new AlertDialog.Builder(activity).setTitle(a2).setMessage(a3).setPositiveButton(a4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.3
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        d.b(activity, oVar);
                                        dialogInterface.cancel();
                                        AlertDialog unused = d.d = null;
                                    }
                                }).setNegativeButton(a5, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.2
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        d.a(false);
                                    }
                                }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.1
                                    @Override // android.content.DialogInterface.OnKeyListener
                                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                                        if (i == 4) {
                                            if (keyEvent.getAction() == 1) {
                                                d.a(false);
                                                return true;
                                            }
                                            return true;
                                        }
                                        return false;
                                    }
                                }).setCancelable(false).show();
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        a(false);
                    }
                }
                oVar.b();
            }
        }
    }

    public static void b(@NonNull Activity activity, @NonNull o oVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    qeg = (com.ss.android.socialbase.appdownloader.view.a) fragmentManager.findFragmentByTag(f13039a);
                    if (qeg == null) {
                        qeg = new com.ss.android.socialbase.appdownloader.view.a();
                        fragmentManager.beginTransaction().add(qeg, f13039a).commitAllowingStateLoss();
                        fragmentManager.executePendingTransactions();
                    }
                    qeg.a();
                    return;
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    oVar.a();
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            }
        }
        oVar.a();
    }
}
