package d.o.a.e.a.f;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import d.o.a.e.a.d;
import d.o.a.e.a.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f66861a = "c";

    /* renamed from: b  reason: collision with root package name */
    public static List<d.p> f66862b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static com.ss.android.socialbase.appdownloader.view.a f66863c;

    /* renamed from: d  reason: collision with root package name */
    public static AlertDialog f66864d;

    /* loaded from: classes7.dex */
    public static class a implements DialogInterface.OnKeyListener {
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 1) {
                    c.c(false);
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            c.c(false);
        }
    }

    /* renamed from: d.o.a.e.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class DialogInterface$OnClickListenerC1842c implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f66865e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.p f66866f;

        public DialogInterface$OnClickListenerC1842c(Activity activity, d.p pVar) {
            this.f66865e = activity;
            this.f66866f = pVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            c.e(this.f66865e, this.f66866f);
            dialogInterface.cancel();
            AlertDialog unused = c.f66864d = null;
        }
    }

    public static synchronized void b(@NonNull Activity activity, @NonNull d.p pVar) {
        synchronized (c.class) {
            if (pVar == null) {
                return;
            }
            if (activity != null) {
                try {
                } catch (Throwable th) {
                    th.printStackTrace();
                    c(false);
                }
                if (!activity.isFinishing()) {
                    int a2 = l.a(d.o.a.e.b.g.d.l(), "tt_appdownloader_notification_request_title");
                    int a3 = l.a(d.o.a.e.b.g.d.l(), "tt_appdownloader_notification_request_message");
                    int a4 = l.a(d.o.a.e.b.g.d.l(), "tt_appdownloader_notification_request_btn_yes");
                    int a5 = l.a(d.o.a.e.b.g.d.l(), "tt_appdownloader_notification_request_btn_no");
                    f66862b.add(pVar);
                    if (f66864d == null || !f66864d.isShowing()) {
                        f66864d = new AlertDialog.Builder(activity).setTitle(a2).setMessage(a3).setPositiveButton(a4, new DialogInterface$OnClickListenerC1842c(activity, pVar)).setNegativeButton(a5, new b()).setOnKeyListener(new a()).setCancelable(false).show();
                    }
                    return;
                }
            }
            pVar.b();
        }
    }

    public static synchronized void c(boolean z) {
        synchronized (c.class) {
            try {
                if (f66864d != null) {
                    f66864d.cancel();
                    f66864d = null;
                }
                for (d.p pVar : f66862b) {
                    if (pVar != null) {
                        if (z) {
                            pVar.a();
                        } else {
                            pVar.b();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static boolean d() {
        try {
            return NotificationManagerCompat.from(d.o.a.e.b.g.d.l()).areNotificationsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static void e(@NonNull Activity activity, @NonNull d.p pVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    com.ss.android.socialbase.appdownloader.view.a aVar = (com.ss.android.socialbase.appdownloader.view.a) fragmentManager.findFragmentByTag(f66861a);
                    f66863c = aVar;
                    if (aVar == null) {
                        f66863c = new com.ss.android.socialbase.appdownloader.view.a();
                        fragmentManager.beginTransaction().add(f66863c, f66861a).commitAllowingStateLoss();
                        fragmentManager.executePendingTransactions();
                    }
                    f66863c.a();
                    return;
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    pVar.a();
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            }
        }
        pVar.a();
    }
}
