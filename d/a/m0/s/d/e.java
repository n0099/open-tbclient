package d.a.m0.s.d;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.view.NavigationBarCoverTip;
import d.a.c.e.m.g;
import d.a.c.e.p.l;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes3.dex */
public class e implements d.a.m0.s.d.a {

    /* renamed from: b  reason: collision with root package name */
    public static final long f50579b = StringHelper.MS_TO_MIN * 1;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.b1.o.a.f.b f50580a;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.b1.o.a.d.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f50581a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f50582b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f50583c;

        public a(Activity activity, TbPageContext tbPageContext, ViewGroup viewGroup) {
            this.f50581a = activity;
            this.f50582b = tbPageContext;
            this.f50583c = viewGroup;
        }

        @Override // d.a.m0.b1.o.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                boolean z = false;
                if ("frs.FrsActivity".equals(this.f50581a.getLocalClassName()) && d.a.m0.r.d0.b.j().g("first_call_attention", true)) {
                    d.a.m0.r.d0.b.j().t("first_call_attention", false);
                    if (!NotificationManagerCompat.from(this.f50582b.getPageActivity()).areNotificationsEnabled()) {
                        z = true;
                    }
                }
                if (z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001223, date));
                    d.a.m0.s.h.a.f(this.f50582b, new boolean[]{true, false}, 2);
                    return;
                }
                e.this.i(true);
                d.d().S(date.getHours(), date.getMinutes());
                e.this.e(this.f50581a, this.f50583c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.b1.o.a.d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f50585a;

        /* loaded from: classes3.dex */
        public class a implements View.OnTouchListener {
            public a(b bVar) {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        /* renamed from: d.a.m0.s.d.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC1152b implements View.OnClickListener {
            public View$OnClickListenerC1152b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.f50580a != null) {
                    e.this.f50580a.A();
                    e.this.f50580a.f();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_OK_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                if (d.a.m0.s.h.a.e(TbadkCoreApplication.getInst(), 0)) {
                    d.a.m0.s.h.a.g(b.this.f50585a, 5, 0L);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements View.OnClickListener {
            public c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.f50580a != null) {
                    e.this.f50580a.f();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_CLOSE_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }

        public b(TbPageContext tbPageContext) {
            this.f50585a = tbPageContext;
        }

        @Override // d.a.m0.b1.o.a.d.a
        public void a(View view) {
            View findViewById = view.findViewById(R.id.layout_bottom_title);
            View findViewById2 = view.findViewById(R.id.layout_bg);
            View findViewById3 = view.findViewById(R.id.layout_bg_top);
            TextView textView = (TextView) view.findViewById(R.id.dialog_yes);
            ImageView imageView = (ImageView) view.findViewById(R.id.dialog_cancel);
            SkinManager.setBackgroundResource(findViewById2, R.color.CAM_X0211);
            SkinManager.setBackgroundResource(findViewById3, R.drawable.pic_frs_popup_sign);
            SkinManager.setViewTextColor(textView, R.color.select_topbar_icon_white_color_tint);
            SkinManager.setImageResource(imageView, R.drawable.selector_topbar_close_white);
            SkinManager.setViewTextColor((TextView) view.findViewById(R.id.tv_title), R.color.CAM_X0101);
            View findViewById4 = view.findViewById(R.id.layout_content);
            SkinManager.setBackgroundColor(findViewById4, R.color.CAM_X0211);
            SkinManager.setViewTextColor((TextView) view.findViewById(R.id.tv_tip), R.color.CAM_X0105);
            SkinManager.setViewTextColor((TextView) view.findViewById(R.id.sign_remind_timer), R.color.CAM_X0105);
            SkinManager.setBackgroundColor((LinearLayout) view.findViewById(R.id.timepicker), R.color.CAM_X0211);
            a aVar = new a(this);
            findViewById.setOnTouchListener(aVar);
            findViewById4.setOnTouchListener(aVar);
            textView.setOnClickListener(new View$OnClickListenerC1152b());
            imageView.setOnClickListener(new c());
        }
    }

    @Override // d.a.m0.s.d.a
    public boolean a() {
        return TbadkSettings.getInst().loadBoolean("alert_sign_on", false);
    }

    @Override // d.a.m0.s.d.a
    public int b() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_mins", -1);
        if (loadInt == -1) {
            m();
            return TbadkSettings.getInst().loadInt("alert_sign_mins", 30);
        }
        return loadInt;
    }

    @Override // d.a.m0.s.d.a
    public void c() {
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        AlarmManager alarmManager = (AlarmManager) inst.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent k = k();
        if (a()) {
            Calendar calendar = Calendar.getInstance();
            int h2 = h();
            int i2 = calendar.get(11);
            int b2 = b();
            int i3 = calendar.get(12);
            calendar.set(11, h2);
            calendar.set(12, b2);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i2 >= h2 && (i2 != h2 || i3 >= b2)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(inst, 0, k, 134217728));
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(inst, 0, k, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
        }
    }

    @Override // d.a.m0.s.d.a
    public Dialog d(TbPageContext tbPageContext, d.a.m0.b1.o.a.d.e eVar) {
        Activity pageActivity;
        if (tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null || !g.e(pageActivity)) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        int i2 = d.d().i();
        int j = d.d().j();
        if (i2 > 0 && j > 0) {
            calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), i2, j);
        } else {
            calendar.setTimeInMillis(System.currentTimeMillis() + f50579b);
        }
        d.a.m0.b1.o.a.b.a aVar = new d.a.m0.b1.o.a.b.a(pageActivity, eVar);
        aVar.g(calendar);
        aVar.k(R.layout.dialog_sign_remind, new b(tbPageContext));
        aVar.f(18);
        aVar.p(new boolean[]{false, false, false, true, true, false});
        aVar.j("年", "月", "日", "时", "分", "秒");
        aVar.l(2.0f);
        aVar.o(0, 0, 0, 0, 0, 0);
        aVar.b(false);
        aVar.i(SkinManager.getColor(R.color.CAM_X0204));
        aVar.m(SkinManager.getColor(R.color.CAM_X0105));
        aVar.n(SkinManager.getColor(R.color.CAM_X0109));
        aVar.d(SkinManager.getColor(R.color.black_alpha30));
        aVar.e(SkinManager.getColor(R.color.CAM_X0211));
        d.a.m0.b1.o.a.f.b a2 = aVar.a();
        this.f50580a = a2;
        a2.u();
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SHOW);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        return this.f50580a.j();
    }

    @Override // d.a.m0.s.d.a
    public NavigationBarCoverTip e(Activity activity, ViewGroup viewGroup) {
        if (activity == null || viewGroup == null) {
            return null;
        }
        View findViewById = viewGroup.findViewById(R.id.navbar_cover_tip_view);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        NavigationBarCoverTip navigationBarCoverTip = new NavigationBarCoverTip(activity);
        navigationBarCoverTip.setId(R.id.navbar_cover_tip_view);
        viewGroup.addView(navigationBarCoverTip, new RelativeLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(activity);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setMinHeight(l(R.dimen.tbds112));
        int l = l(R.dimen.tbds20);
        textView.setPadding(l, 0, l, 0);
        textView.setGravity(17);
        textView.setTextSize(0, l(R.dimen.tbfontsize42));
        textView.setLineSpacing(l(R.dimen.ds2), 1.0f);
        textView.setText(activity.getString(R.string.sign_remind_timer_succ));
        SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(navigationBarCoverTip, R.color.cp_link_tip_a_alpha95);
        navigationBarCoverTip.l(activity, textView);
        return navigationBarCoverTip;
    }

    @Override // d.a.m0.s.d.a
    public void f(TbPageContext tbPageContext, ViewGroup viewGroup) {
        Activity pageActivity;
        if (tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null || !g.e(pageActivity) || d.d().y() || d.a.m0.r.d0.b.j().k("sign_time_set_dialog", 0) > 0) {
            return;
        }
        d(tbPageContext, new a(pageActivity, tbPageContext, viewGroup));
        d.a.m0.r.d0.b.j().v("sign_time_set_dialog", 1);
    }

    @Override // d.a.m0.s.d.a
    public void g(int i2, int i3) {
        TbadkSettings.getInst().saveInt("alert_sign_hours", i2);
        TbadkSettings.getInst().saveInt("alert_sign_mins", i3);
        c();
    }

    @Override // d.a.m0.s.d.a
    public int h() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_hours", -1);
        if (loadInt == -1) {
            m();
            return TbadkSettings.getInst().loadInt("alert_sign_hours", 12);
        }
        return loadInt;
    }

    @Override // d.a.m0.s.d.a
    public void i(boolean z) {
        TbadkSettings.getInst().saveBoolean("alert_sign_on", z);
        c();
    }

    public Intent k() {
        Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(TbadkCoreApplication.getInst(), SignAlertReceiver.class);
        return intent;
    }

    public final int l(int i2) {
        return l.g(TbadkCoreApplication.getInst(), i2);
    }

    public final void m() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis() + f50579b);
        g(calendar.get(11), calendar.get(12));
    }
}
