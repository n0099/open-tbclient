package com.mofamulu.tieba.ch;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TabActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.pb.ImageActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.write.WriteActivity;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class a {
    public static int a;
    public static String b;
    private static boolean c = true;
    private static boolean d = false;
    private static ThreadPoolExecutor e = new ThreadPoolExecutor(1, 10, 70, TimeUnit.SECONDS, new LinkedBlockingQueue(100));

    public static void a() {
        c = true;
    }

    public static void a(Activity activity, Bundle bundle) {
        if (!d) {
            d = true;
            try {
                com.mofamulu.tieba.tail.b.a().b();
            } catch (Throwable th) {
                d = false;
            }
        }
        if (activity instanceof PersonInfoActivity) {
            p.a((PersonInfoActivity) activity);
        } else if (activity instanceof ImageActivity) {
            com.mofamulu.tieba.dslv.lock.a.d = true;
        }
    }

    public static void a(Activity activity) {
        RadioButton radioButton;
        if (c && (activity.getParent() instanceof TabActivity) && (radioButton = (RadioButton) ((TabActivity) activity.getParent()).getTabHost().findViewById(R.id.radio_recommend)) != null) {
            int i = bg.c().H() ? 8 : 0;
            if (i != radioButton.getVisibility()) {
                radioButton.setVisibility(i);
            }
            c = false;
            if (a > 0) {
                if (bf.b(b)) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://book.mofamulu.com/api/android/new_version.jsp?v=" + activity.getString(R.string.tbhp_version_num)));
                        intent.setFlags(268435456);
                        PendingIntent activity2 = PendingIntent.getActivity(activity, 0, intent, 268435456);
                        Notification notification = new Notification(R.drawable.icon, activity.getString(R.string.app_name), System.currentTimeMillis());
                        notification.setLatestEventInfo(activity, b, b, activity2);
                        ((NotificationManager) activity.getSystemService("notification")).notify(100, notification);
                    } catch (Throwable th) {
                        Log.e("tbhp", "failed to sendNotification", th);
                    }
                    Toast.makeText(activity, b, 1).show();
                }
                if (a == 1) {
                    a = 0;
                } else if (a == 63) {
                    new b().start();
                } else {
                    a = 0;
                }
            }
        }
        com.mofamulu.tieba.dslv.lock.a.a.c(activity);
    }

    public static void a(Activity activity, int i) {
        boolean z = TiebaApplication.f().as() == 1;
        if (activity instanceof PersonInfoActivity) {
            f.a((PersonInfoActivity) activity, z);
        } else if (activity instanceof MoreActivity) {
            m.b(activity, i);
        } else if (activity instanceof WriteActivity) {
            TextView textView = (TextView) activity.findViewById(R.id.tail_text);
            TextView textView2 = (TextView) activity.findViewById(R.id.select_ems);
            if (textView != null) {
                if (z) {
                    int color = activity.getResources().getColor(R.color.skin_1_common_color);
                    textView.setTextColor(color);
                    textView2.setTextColor(color);
                    return;
                }
                int color2 = activity.getResources().getColor(R.color.more_color);
                textView.setTextColor(color2);
                textView2.setTextColor(color2);
            }
        } else if (activity instanceof FrsActivity) {
            be.a((ViewGroup) activity.findViewById(R.id.scroll_view), i);
            TextView textView3 = (TextView) activity.findViewById(R.id.help_title);
            if (i == 1) {
                textView3.setTextColor(-13025722);
            } else {
                textView3.setTextColor(-11974069);
            }
        }
    }

    public static void b(Activity activity) {
        com.mofamulu.tieba.dslv.lock.a.a.a(activity);
    }

    public static void c(Activity activity) {
        if (activity instanceof PersonInfoActivity) {
            p.b((PersonInfoActivity) activity);
            f.b((PersonInfoActivity) activity);
        }
        com.mofamulu.tieba.dslv.lock.a.a.b(activity);
    }

    public static void b(Activity activity, int i) {
        if (i == R.layout.about_activity) {
            m.c(activity, i);
        } else if (i == R.layout.more_activity) {
            m.a(activity, i);
            a();
        } else if (i == R.layout.person_info_activity) {
            p.a((PersonInfoActivity) activity, i);
            a();
        } else if (i == R.layout.new_home_activity) {
            a();
        } else if (i == R.layout.enter_forum_enter) {
            a();
        }
    }

    public static void b(Activity activity, Bundle bundle) {
        bg c2 = bg.c();
        c2.p();
        if (activity instanceof WriteActivity) {
            com.mofamulu.tieba.tail.aq.b(activity, c2, bundle);
        } else if (activity instanceof NewPbActivity) {
            com.mofamulu.tieba.tail.aq.a(activity, c2, bundle);
        } else if (activity instanceof MoreActivity) {
            m.a(activity, bundle);
        } else if (activity instanceof FrsActivity) {
            View findViewById = activity.findViewById(R.id.ranklist);
            View findViewById2 = activity.findViewById(R.id.enter_bawu_admin);
            View findViewById3 = activity.findViewById(R.id.enter_gcode);
            View findViewById4 = activity.findViewById(R.id.enter_kaka);
            View findViewById5 = activity.findViewById(R.id.enter_mofamumulu);
            View findViewById6 = activity.findViewById(R.id.enter_3force);
            d dVar = new d(activity);
            if (findViewById != null) {
                findViewById.setOnClickListener(dVar);
            }
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(dVar);
            }
            if (findViewById3 != null) {
                findViewById3.setOnClickListener(dVar);
            }
            if (findViewById4 != null) {
                findViewById4.setOnClickListener(dVar);
            }
            if (findViewById5 != null) {
                findViewById5.setOnClickListener(dVar);
            }
            if (findViewById6 != null) {
                findViewById6.setOnClickListener(dVar);
            }
        } else if (activity instanceof PersonInfoActivity) {
            f.a((PersonInfoActivity) activity, bundle);
        }
    }

    public static boolean b() {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    public static void a(Runnable runnable) {
        try {
            if (b()) {
                e.submit(runnable);
            } else {
                runnable.run();
            }
        } catch (Throwable th) {
            Log.e("tbhp_thread", "failed to execute task:" + runnable, th);
        }
    }
}
