package d.b.i0.s.d;

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
import d.b.c.e.m.g;
import d.b.c.e.p.l;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes3.dex */
public class e implements d.b.i0.s.d.a {

    /* renamed from: b  reason: collision with root package name */
    public static final long f52029b = StringHelper.MS_TO_MIN * 1;

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.b1.o.a.f.b f52030a;

    /* loaded from: classes3.dex */
    public class a implements d.b.i0.b1.o.a.d.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f52031a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f52032b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f52033c;

        public a(Activity activity, TbPageContext tbPageContext, ViewGroup viewGroup) {
            this.f52031a = activity;
            this.f52032b = tbPageContext;
            this.f52033c = viewGroup;
        }

        @Override // d.b.i0.b1.o.a.d.e
        public void a(Date date, View view) {
            if (date != null) {
                boolean z = false;
                if ("frs.FrsActivity".equals(this.f52031a.getLocalClassName()) && d.b.i0.r.d0.b.j().g("first_call_attention", true)) {
                    d.b.i0.r.d0.b.j().t("first_call_attention", false);
                    if (!NotificationManagerCompat.from(this.f52032b.getPageActivity()).areNotificationsEnabled()) {
                        z = true;
                    }
                }
                if (z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001223, date));
                    d.b.i0.s.h.a.f(this.f52032b, new boolean[]{true, false}, 2);
                    return;
                }
                e.this.g(true);
                d.d().S(date.getHours(), date.getMinutes());
                e.this.i(this.f52031a, this.f52033c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.i0.b1.o.a.d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f52035a;

        /* loaded from: classes3.dex */
        public class a implements View.OnTouchListener {
            public a(b bVar) {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        /* renamed from: d.b.i0.s.d.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC1129b implements View.OnClickListener {
            public View$OnClickListenerC1129b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.f52030a != null) {
                    e.this.f52030a.E();
                    e.this.f52030a.f();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_OK_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                if (d.b.i0.s.h.a.e(TbadkCoreApplication.getInst(), 0)) {
                    d.b.i0.s.h.a.g(b.this.f52035a, 5, 0L);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements View.OnClickListener {
            public c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.f52030a != null) {
                    e.this.f52030a.f();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_CLOSE_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }

        public b(TbPageContext tbPageContext) {
            this.f52035a = tbPageContext;
        }

        @Override // d.b.i0.b1.o.a.d.a
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
            textView.setOnClickListener(new View$OnClickListenerC1129b());
            imageView.setOnClickListener(new c());
        }
    }

    @Override // d.b.i0.s.d.a
    public boolean a() {
        return TbadkSettings.getInst().loadBoolean("alert_sign_on", false);
    }

    @Override // d.b.i0.s.d.a
    public void b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        Activity pageActivity;
        if (tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null || !g.e(pageActivity) || d.d().y() || d.b.i0.r.d0.b.j().k("sign_time_set_dialog", 0) > 0) {
            return;
        }
        h(tbPageContext, new a(pageActivity, tbPageContext, viewGroup));
        d.b.i0.r.d0.b.j().v("sign_time_set_dialog", 1);
    }

    @Override // d.b.i0.s.d.a
    public int c() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_mins", -1);
        if (loadInt == -1) {
            m();
            return TbadkSettings.getInst().loadInt("alert_sign_mins", 30);
        }
        return loadInt;
    }

    @Override // d.b.i0.s.d.a
    public void d(int i, int i2) {
        TbadkSettings.getInst().saveInt("alert_sign_hours", i);
        TbadkSettings.getInst().saveInt("alert_sign_mins", i2);
        e();
    }

    @Override // d.b.i0.s.d.a
    public void e() {
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        AlarmManager alarmManager = (AlarmManager) inst.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent k = k();
        if (a()) {
            Calendar calendar = Calendar.getInstance();
            int f2 = f();
            int i = calendar.get(11);
            int c2 = c();
            int i2 = calendar.get(12);
            calendar.set(11, f2);
            calendar.set(12, c2);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i >= f2 && (i != f2 || i2 >= c2)) {
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

    @Override // d.b.i0.s.d.a
    public int f() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_hours", -1);
        if (loadInt == -1) {
            m();
            return TbadkSettings.getInst().loadInt("alert_sign_hours", 12);
        }
        return loadInt;
    }

    @Override // d.b.i0.s.d.a
    public void g(boolean z) {
        TbadkSettings.getInst().saveBoolean("alert_sign_on", z);
        e();
    }

    @Override // d.b.i0.s.d.a
    public Dialog h(TbPageContext tbPageContext, d.b.i0.b1.o.a.d.e eVar) {
        Activity pageActivity;
        if (tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null || !g.e(pageActivity)) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        int i = d.d().i();
        int j = d.d().j();
        if (i > 0 && j > 0) {
            calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), i, j);
        } else {
            calendar.setTimeInMillis(System.currentTimeMillis() + f52029b);
        }
        d.b.i0.b1.o.a.b.a aVar = new d.b.i0.b1.o.a.b.a(pageActivity, eVar);
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
        d.b.i0.b1.o.a.f.b a2 = aVar.a();
        this.f52030a = a2;
        a2.w();
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SHOW);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        return this.f52030a.k();
    }

    @Override // d.b.i0.s.d.a
    public NavigationBarCoverTip i(Activity activity, ViewGroup viewGroup) {
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

    public Intent k() {
        Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(TbadkCoreApplication.getInst(), SignAlertReceiver.class);
        return intent;
    }

    public final int l(int i) {
        return l.g(TbadkCoreApplication.getInst(), i);
    }

    public final void m() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis() + f52029b);
        d(calendar.get(11), calendar.get(12));
    }
}
