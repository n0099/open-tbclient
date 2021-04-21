package d.b.j0.d3.g0;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.b.i0.r.s.a;
import java.util.Date;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static d.b.c.e.g.c f55218a;

    /* renamed from: d.b.j0.d3.g0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1264a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f55219e;

        public C1264a(TbPageContext tbPageContext) {
            this.f55219e = tbPageContext;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f55219e.getPageActivity(), true, 23004, "remind");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements a.e {
        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
            TiebaStatic.log(TbadkCoreStatisticKey.REMIND_EXPIRED);
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements d.b.c.e.g.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f55220a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f55221b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpannableString f55222c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f55223d;

        /* renamed from: d.b.j0.d3.g0.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1265a implements View.OnClickListener {
            public View$OnClickListenerC1265a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.f55218a != null) {
                    a.f55218a.d();
                }
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) c.this.f55220a.getPageActivity(), true, 23004, "expiring");
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }

        public c(TbPageContext tbPageContext, boolean z, SpannableString spannableString, int i) {
            this.f55220a = tbPageContext;
            this.f55221b = z;
            this.f55222c = spannableString;
            this.f55223d = i;
        }

        @Override // d.b.c.e.g.b
        public int a() {
            return this.f55221b ? 4 : 2;
        }

        @Override // d.b.c.e.g.b
        public View b(LayoutInflater layoutInflater) {
            TextView textView = new TextView(this.f55220a.getPageActivity());
            if (this.f55221b) {
                textView.setBackgroundResource(R.drawable.pop_float_top);
            } else {
                textView.setBackgroundResource(R.drawable.pop_float);
            }
            int dimensionPixelSize = this.f55220a.getResources().getDimensionPixelSize(R.dimen.ds32);
            int dimensionPixelSize2 = this.f55220a.getResources().getDimensionPixelSize(R.dimen.ds22);
            if (this.f55221b) {
                textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
            } else {
                textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
            }
            textView.setGravity(17);
            textView.setText(this.f55222c);
            textView.setCompoundDrawablePadding(dimensionPixelSize);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(this.f55223d), (Drawable) null);
            textView.setOnClickListener(new View$OnClickListenerC1265a());
            return textView;
        }

        @Override // d.b.c.e.g.b
        public int c() {
            return this.f55221b ? 32 : 16;
        }

        @Override // d.b.c.e.g.b
        public int getXOffset() {
            return this.f55221b ? 0 : 4;
        }

        @Override // d.b.c.e.g.b
        public int getYOffset() {
            return this.f55221b ? 5 : 30;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f55225e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f55226f;

        public d(TbPageContext tbPageContext, boolean z) {
            this.f55225e = tbPageContext;
            this.f55226f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.d(this.f55225e.getPageActivity(), this.f55226f);
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (a.f55218a != null) {
                a.f55218a.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void onRefresh();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: d.b.c.e.g.d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v7 */
    public static void c(TbPageContext tbPageContext, View view, boolean z, f fVar) {
        int i;
        SpannableString spannableString;
        ?? r12;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class)) {
            long defaultBubbleEndTime = TbadkCoreApplication.getInst().getDefaultBubbleEndTime();
            if (defaultBubbleEndTime <= 0) {
                return;
            }
            long currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis >= defaultBubbleEndTime) {
                MessageManager.getInstance().runTask(2001283, TbPageContext.class, tbPageContext);
                TbadkCoreApplication.getInst().setDefaultBubble(null);
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(0);
                if (fVar != null) {
                    fVar.onRefresh();
                }
                d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(tbPageContext.getPageActivity());
                aVar.setCanceledOnTouchOutside(false);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.bubble_free_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.tip1);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tip2);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                textView.setText(tbPageContext.getPageActivity().getString(R.string.bubble_ended_tip));
                textView2.setText(tbPageContext.getPageActivity().getString(R.string.bubble_ended_tip2));
                textView2.setTextSize(0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.fontsize32));
                aVar.setContentView(inflate);
                aVar.setPositiveButton(R.string.open_now, new C1264a(tbPageContext));
                aVar.setNegativeButton(R.string.group_create_private_isee, new b());
                aVar.create(tbPageContext);
                aVar.show();
                return;
            }
            long j = (defaultBubbleEndTime - currentTimeMillis) / 86400;
            if (j > 3 || j < 0) {
                return;
            }
            if (System.currentTimeMillis() / 86400000 == d.b.i0.r.d0.b.j().l("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                return;
            }
            int i2 = R.color.CAM_X0111;
            int i3 = R.color.CAM_X0305;
            int i4 = R.drawable.pop_float_arrow;
            if (i == 0) {
                if (new Date(currentTimeMillis).getDay() == new Date(defaultBubbleEndTime).getDay()) {
                    spannableString = new SpannableString(tbPageContext.getPageActivity().getString(R.string.bubble_end_time_tip_today));
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i2)), 0, spannableString.length(), 34);
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i3)), 9, 13, 34);
                } else {
                    spannableString = new SpannableString(String.format(tbPageContext.getPageActivity().getString(R.string.bubble_end_time_tip), 1));
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i2)), 0, spannableString.length(), 34);
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i3)), 10, 14, 34);
                }
                r12 = 0;
            } else {
                String string = tbPageContext.getPageActivity().getString(R.string.bubble_end_time_tip);
                Long valueOf = Long.valueOf(j);
                r12 = 0;
                spannableString = new SpannableString(String.format(string, valueOf));
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i2)), 0, spannableString.length(), 34);
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i3)), 10, 14, 34);
            }
            d.b.c.e.g.d dVar = new d.b.c.e.g.d();
            dVar.j(view);
            dVar.c(r12);
            dVar.i(r12);
            dVar.a(new c(tbPageContext, z, spannableString, i4));
            dVar.d(true);
            dVar.h(r12);
            f55218a = dVar.b();
            new Handler().postDelayed(new d(tbPageContext, z), 1000L);
            d.b.i0.r.d0.b.j().w("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis() / 86400000);
        }
    }

    public static void d(Activity activity, boolean z) {
        d.b.c.e.g.c cVar = f55218a;
        if (cVar != null) {
            cVar.n(activity);
        }
        if (z) {
            return;
        }
        new Handler().postDelayed(new e(), 5000L);
    }
}
