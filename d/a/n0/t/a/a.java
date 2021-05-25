package d.a.n0.t.a;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdType;
import com.baidu.tieba.advert.sdk.data.RedirectType;
import com.baidu.tieba.advert.sdk.view.SplashAdView;
import com.baidu.tieba.advert.sdk.widget.CountDownTextView;
import d.a.c.e.p.l;
import d.a.m0.s.c.m;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public e f60762a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f60763b = null;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<SplashAdView> f60764c;

    /* renamed from: d.a.n0.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1605a implements CustomMessageTask.CustomRunnable<m> {
        public C1605a() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<m> customMessage) {
            if (customMessage != null && customMessage.getCmd() == 2016310) {
                try {
                    return new CustomResponsedMessage<>(2016310, a.this.f(customMessage.getData()));
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.n0.t.a.g.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SplashAdView f60766a;

        public b(SplashAdView splashAdView) {
            this.f60766a = splashAdView;
        }

        @Override // d.a.n0.t.a.g.a
        public void a(String str) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, str));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_STATISTICS_ADVERTSDK_CLICK);
            statisticItem.param("obj_source", str);
            TiebaStatic.log(statisticItem);
        }

        @Override // d.a.n0.t.a.g.a
        public void b(d.a.n0.t.a.f.a aVar) {
        }

        @Override // d.a.n0.t.a.g.a
        public void c() {
        }

        @Override // d.a.n0.t.a.g.a
        public void d() {
            d.a.n0.t.a.f.b entryInfoData;
            SplashAdView splashAdView = (SplashAdView) a.this.f60764c.get();
            if (splashAdView != null) {
                a.this.f60763b = this.f60766a.g();
                a aVar = a.this;
                aVar.h(aVar.f60763b);
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_STATISTICS_ADVERTSDK_SHOW);
            if (splashAdView != null && (entryInfoData = splashAdView.getEntryInfoData()) != null) {
                if (entryInfoData.d()) {
                    statisticItem.param("obj_source", entryInfoData.f60806e);
                } else {
                    statisticItem.param("obj_source", entryInfoData.f60803b);
                }
            }
            TiebaStatic.log(statisticItem);
        }

        @Override // d.a.n0.t.a.g.a
        public void e() {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements CountDownTextView.d {
        public d(a aVar) {
        }

        @Override // com.baidu.tieba.advert.sdk.widget.CountDownTextView.d
        public void a(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
        }
    }

    /* loaded from: classes4.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f60768a;

        public /* synthetic */ e(CountDownTextView countDownTextView, C1605a c1605a) {
            this(countDownTextView);
        }

        public void a(String str) {
            CountDownTextView countDownTextView = this.f60768a.get();
            if (countDownTextView != null) {
                countDownTextView.d(str, 0);
            }
        }

        public e(CountDownTextView countDownTextView) {
            this.f60768a = new WeakReference<>(countDownTextView);
        }
    }

    public final View f(m mVar) {
        boolean z;
        if (mVar == null || !mVar.d()) {
            return null;
        }
        Activity pageActivity = mVar.c().getPageActivity();
        int a2 = mVar.a();
        int b2 = mVar.b();
        SplashAdView splashAdView = new SplashAdView(mVar.c(), "1481698145541", AdType.SPLASH, a2, b2, RedirectType.APPMANAGE);
        splashAdView.setLayoutParams(new RelativeLayout.LayoutParams(b2, a2));
        this.f60764c = new WeakReference<>(splashAdView);
        splashAdView.setBCAdCallBack(new b(splashAdView));
        try {
            z = splashAdView.f();
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            try {
                int dimension = (int) pageActivity.getResources().getDimension(R.dimen.ds22);
                int dimension2 = (int) pageActivity.getResources().getDimension(R.dimen.ds36);
                Activity pageActivity2 = mVar.c().getPageActivity();
                if (UtilHelper.isNotchScreen(pageActivity2) || UtilHelper.isCutoutScreen(pageActivity2)) {
                    dimension2 += l.r(pageActivity2);
                }
                int dimension3 = (int) pageActivity.getResources().getDimension(R.dimen.ds32);
                int dimension4 = (int) pageActivity.getResources().getDimension(R.dimen.ds106);
                int dimension5 = (int) pageActivity.getResources().getDimension(R.dimen.ds52);
                CountDownTextView countDownTextView = new CountDownTextView(pageActivity);
                this.f60762a = new e(countDownTextView, null);
                String str = this.f60763b;
                if (TextUtils.isEmpty(str)) {
                    str = pageActivity.getResources().getString(R.string.skip);
                }
                if (splashAdView.r) {
                    countDownTextView.d(str, 6);
                } else {
                    countDownTextView.d(str, 3);
                }
                splashAdView.setTag(Boolean.valueOf(splashAdView.r));
                float f2 = dimension;
                countDownTextView.setTextSize(0, f2);
                countDownTextView.setTextColor(Color.parseColor("#ffffff"));
                countDownTextView.setGravity(17);
                countDownTextView.setAlpha(0.5f);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#000000"));
                gradientDrawable.setCornerRadius(pageActivity.getResources().getDimension(R.dimen.ds4));
                gradientDrawable.setStroke(1, Color.parseColor("#000000"));
                countDownTextView.setBackgroundDrawable(gradientDrawable);
                countDownTextView.setOnClickListener(new c(this));
                countDownTextView.setTimeoutListener(new d(this));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimension4, dimension5);
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.setMargins(0, dimension2, dimension3, 0);
                int g2 = l.g(pageActivity, R.dimen.ds9);
                countDownTextView.setPadding(g2, g2, g2, g2);
                splashAdView.addView(countDownTextView, layoutParams);
                int dimension6 = (int) pageActivity.getResources().getDimension(R.dimen.ds28);
                TextView textView = new TextView(pageActivity);
                textView.setText(R.string.advert_label);
                textView.setTextSize(0, f2);
                textView.setAlpha(0.5f);
                textView.setIncludeFontPadding(false);
                textView.setGravity(17);
                textView.setBackgroundDrawable(gradientDrawable.getConstantState().newDrawable());
                int g3 = l.g(pageActivity, R.dimen.ds2);
                textView.setPadding(g3, g3, g3, g3);
                SkinManager.setViewTextColor(textView, R.color.common_color_10013);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) pageActivity.getResources().getDimension(R.dimen.ds68), (int) pageActivity.getResources().getDimension(R.dimen.ds40));
                layoutParams2.setMargins(dimension6, 0, 0, dimension6);
                layoutParams2.addRule(9);
                layoutParams2.addRule(12);
                splashAdView.addView(textView, layoutParams2);
            } catch (Exception unused2) {
            }
            return splashAdView;
        }
        return null;
    }

    public void g() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016310, new C1605a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public final void h(String str) {
        if (this.f60762a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f60762a.a(str);
    }
}
