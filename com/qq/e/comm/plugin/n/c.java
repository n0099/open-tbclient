package com.qq.e.comm.plugin.n;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ac.i;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.n.b;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.ao;
import com.qq.e.comm.plugin.util.ap;
import com.qq.e.comm.plugin.util.q;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.plugin.y.u;
/* loaded from: classes3.dex */
public class c extends RelativeLayout implements View.OnClickListener, g {

    /* renamed from: a  reason: collision with root package name */
    private static int f12234a = Color.parseColor("#333333");

    /* renamed from: b  reason: collision with root package name */
    private static int f12235b = Color.parseColor("#7F7F7F");
    private static int c = Color.parseColor("#EFF3F9");
    private static int d = Color.parseColor("#3171F4");
    private static int e = Color.parseColor("#EFF3F9");
    private static final int n = GDTADManager.getInstance().getSM().getInteger("mdpa_card_btn_animation_time", 3);
    private com.qq.e.comm.plugin.s.a f;
    private b.a g;
    private com.qq.e.comm.plugin.ad.g h;
    private TextView i;
    private boolean j;
    private volatile boolean k;
    private com.qq.e.comm.plugin.y.c l;
    private r m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, com.qq.e.comm.plugin.s.a aVar, com.qq.e.comm.plugin.y.c cVar) {
        super(context);
        this.f = aVar;
        this.l = cVar;
        e();
        this.m = new r(context);
    }

    private RelativeLayout a(com.qq.e.comm.plugin.ad.k kVar) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(15);
        layoutParams.addRule(1, 2131755009);
        layoutParams.addRule(3, 2131755014);
        layoutParams.leftMargin = ak.a(getContext(), 4);
        layoutParams.topMargin = ak.a(getContext(), 12);
        layoutParams.rightMargin = ak.a(getContext(), 4);
        layoutParams.bottomMargin = ak.a(getContext(), 4);
        relativeLayout.setLayoutParams(layoutParams);
        com.qq.e.comm.plugin.ac.j jVar = new com.qq.e.comm.plugin.ac.j(getContext());
        jVar.setId(2131755014);
        jVar.a(ak.a(getContext(), 8));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ak.a(getContext(), 16), ak.a(getContext(), 16));
        layoutParams2.addRule(9);
        layoutParams2.addRule(10);
        layoutParams2.leftMargin = ak.a(getContext(), 8);
        if (TextUtils.isEmpty(this.f.p())) {
            jVar.setVisibility(4);
        } else {
            com.qq.e.comm.plugin.p.a.a().a(this.f.p(), jVar);
        }
        relativeLayout.addView(jVar, layoutParams2);
        TextView textView = new TextView(getContext());
        textView.setId(R.style.AppBaseTheme);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(1, 2131755014);
        layoutParams3.leftMargin = ak.a(getContext(), 4);
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(f12235b);
        if (!this.f.v()) {
            textView.setText(this.f.n());
        } else if (this.f.z() != null) {
            textView.setText(this.f.z().i());
        } else {
            textView.setText(this.f.n());
        }
        relativeLayout.addView(textView, layoutParams3);
        TextView textView2 = new TextView(getContext());
        textView2.setId(2131755010);
        textView2.setTypeface(Typeface.defaultFromStyle(1));
        textView2.setLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, 2131755014);
        layoutParams4.addRule(0, R.style.AppTheme);
        layoutParams4.leftMargin = ak.a(getContext(), 8);
        layoutParams4.topMargin = ak.a(getContext(), 5);
        layoutParams4.rightMargin = ak.a(getContext(), 12);
        textView2.setTextSize(2, 14.0f);
        textView2.setTextColor(f12234a);
        if (TextUtils.isEmpty(kVar.f11897b)) {
            textView2.setVisibility(4);
        } else {
            textView2.setText(kVar.f11897b);
        }
        relativeLayout.addView(textView2, layoutParams4);
        TextView textView3 = new TextView(getContext());
        textView3.setId(2131755013);
        textView3.setTypeface(Typeface.defaultFromStyle(1));
        textView3.setLines(1);
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(3, 2131755010);
        layoutParams5.addRule(9);
        layoutParams5.addRule(1, 2131755009);
        layoutParams5.addRule(0, R.style.AppTheme);
        layoutParams5.leftMargin = ak.a(getContext(), 8);
        layoutParams5.rightMargin = ak.a(getContext(), 12);
        layoutParams5.topMargin = ak.a(getContext(), 1);
        textView3.setTextSize(2, 14.0f);
        textView3.setTextColor(f12234a);
        if (TextUtils.isEmpty(kVar.e)) {
            textView3.setVisibility(4);
        } else {
            textView3.setText(kVar.e);
        }
        relativeLayout.addView(textView3, layoutParams5);
        String[] strArr = kVar.c;
        if (strArr != null) {
            TextView f = f();
            f.setId(2131755011);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams6.leftMargin = ak.a(getContext(), 8);
            layoutParams6.topMargin = ak.a(getContext(), 6);
            layoutParams6.addRule(3, 2131755013);
            layoutParams6.addRule(9);
            if (strArr.length > 0) {
                f.setText(kVar.c[0]);
            } else {
                f.setVisibility(8);
            }
            relativeLayout.addView(f, layoutParams6);
            TextView f2 = f();
            f2.setId(2131755012);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams7.leftMargin = ak.a(getContext(), 4);
            layoutParams7.topMargin = ak.a(getContext(), 6);
            layoutParams7.addRule(3, 2131755013);
            layoutParams7.addRule(1, 2131755011);
            if (strArr.length > 1) {
                f2.setText(kVar.c[1]);
            } else {
                f2.setVisibility(8);
            }
            relativeLayout.addView(f2, layoutParams7);
        }
        TextView f3 = f();
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(1, 2131755012);
        layoutParams8.addRule(3, 2131755013);
        layoutParams8.leftMargin = ak.a(getContext(), 4);
        layoutParams8.topMargin = ak.a(getContext(), 6);
        if (TextUtils.isEmpty(kVar.d)) {
            f3.setVisibility(8);
        } else {
            f3.setText(kVar.d);
        }
        relativeLayout.addView(f3, layoutParams8);
        int a2 = ak.a(getContext(), 60);
        int a3 = ak.a(getContext(), 28);
        String str = (TextUtils.isEmpty(kVar.f) || !(com.qq.e.comm.plugin.util.b.a(getContext(), this.f) || !this.f.v())) ? "查看" : kVar.f;
        com.qq.e.comm.plugin.ac.i a4 = new i.a().a(this.f).a(ak.a(getContext(), 3)).b(a2).c(a3).d(12).e(d).f(-1).g(d).a(new String[]{str, str, "下载中", "安装", str}).a(new com.qq.e.comm.plugin.a.d.a() { // from class: com.qq.e.comm.plugin.n.c.2
            @Override // com.qq.e.comm.plugin.a.d.a
            public void a(String str2, int i, int i2, long j) {
                if (i == 4) {
                    if (c.this.i == null) {
                        c.this.k = false;
                        return;
                    }
                    c.this.i.setBackgroundDrawable(null);
                    c.this.k = true;
                }
            }
        }).a(getContext());
        a4.setId(R.style.AppTheme);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(a2, a3);
        layoutParams9.addRule(11);
        layoutParams9.addRule(15);
        layoutParams9.rightMargin = ak.a(getContext(), 12);
        this.i = a4.f11857b;
        int i = d;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(8);
        gradientDrawable.setStroke(3, i);
        this.i.setBackgroundDrawable(gradientDrawable);
        relativeLayout.addView(a4, layoutParams9);
        return relativeLayout;
    }

    private void e() {
        if (this.f == null) {
            ai.a("DpaCardView", "init, adData null");
            return;
        }
        com.qq.e.comm.plugin.ad.k ab = this.f.ab();
        if (ab == null) {
            ai.a("DpaCardView", "init, dpaData null");
            return;
        }
        ai.a("DpaCardView", "dpaData : " + ab.toString());
        d = q.b(this.f);
        com.qq.e.comm.plugin.ac.j jVar = new com.qq.e.comm.plugin.ac.j(getContext());
        jVar.setId(2131755009);
        jVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        jVar.setImageDrawable(new ColorDrawable(e));
        jVar.a(ak.a(getContext(), 5));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ak.a(getContext(), 88), ak.a(getContext(), 88));
        layoutParams.addRule(9);
        layoutParams.addRule(3, 2131755014);
        layoutParams.leftMargin = ak.a(getContext(), 4);
        layoutParams.topMargin = ak.a(getContext(), 4);
        layoutParams.bottomMargin = ak.a(getContext(), 8);
        if (TextUtils.isEmpty(ab.f11896a)) {
            jVar.setVisibility(4);
        } else {
            com.qq.e.comm.plugin.p.a.a().a(ab.f11896a, jVar, new com.qq.e.comm.plugin.p.b() { // from class: com.qq.e.comm.plugin.n.c.1
                @Override // com.qq.e.comm.plugin.p.b
                public void a(String str, int i, Exception exc) {
                    ImageView imageView = new ImageView(c.this.getContext());
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.leftMargin = ak.a(c.this.getContext(), 27);
                    layoutParams2.addRule(15);
                    imageView.setLayoutParams(layoutParams2);
                    imageView.setImageBitmap(ao.a("iVBORw0KGgoAAAANSUhEUgAAAIoAAAB4CAYAAAAt3Wp2AAAAAXNSR0IArs4c6QAAEIBJREFUeAHtXXuMXFUZP+fOzm7bpe/uzmtBEEmtEVBIA31qFWyRYilYAlWBauQvRBFKCaISJWJ4JAQDiRqhGqVSRJ4RCEoFa7RACT6AYCRQ3Ll3Zre0dLftsrsz9/j7pjtldh73eebOvbPnJpu9c873nfN93/nd8z7f4cziEUJ05PP5lUXBVzNTrGBcpIVgCbBMs2BTUS20AOd8GGWU54zt4Zz9ibHY0+l0z8t+RUJ6tQ8A0mkYA5sEE9fj/fhaChUSKQtwvotp7Oa+ZPIJr3LXAEXX937UZIXtTIiTvSaq+MJpAc74Y93d0y6fM2fOfrcSTgKKYRjnmoI/gFqk221Cij4aFkBz9I6Id5zd19PzHzcSHwVKNptfJpj5DJinu0lA0UbPAujHvN0Zjy3t6ekxnEqvEWH/0NB8xsxH8apA4tRyEaajfufYWPEh/D9aUdipUwKKdvDQzYIxgEU9U8UCGKgsyeYGL3WqL8++++6xbHT8baCrBBqnjIou+hag/ko6lTweTRHqCetHE6OFDQok1kZq11jMtxyXHRg404l+GobB5zohVDRtaoGiWOtEMw3VzwlOCBVNe1oAvVlH5a+h2cm0pwmUVk4sgE5t2gldB4g6nRAqGqkWGENN/ixj/BV80Qbnmo4PtktwE2tpPMOFWIne5Sel5tgoMcG7GkVVhhNQ1BOQBQCOlzBzcVtXR8eTmOwatspW1/cdZ/LxDQDNZoCIFmJb+vD+rGE7NGqphG2QOQCyh2l8SzqR2O5kKFqp8sDAwDHj48VrUUhbEN6EVXv+975MckllnvXe1dxJPatIDePPHtM947RMMvmAW5CQGL29vQczmdRNMS2+Ek2VLlU0F4kpoLgwlltSrNbel0knVs+ePXufW95q+lRqwYtdnbHFjPN/V8cF8VsBpUlWBkj+mE4nvo5apCArC/RrdI11rUVTNigrTafpKKA4tZQbOs7fxL6PiwCSohs2J7Tp9Nw9nMUuaEbaVvkroFhZx2Mc19i3vWwOcppdOt27E53bXzill0GngCLDihVpoFnYiY7rYxVBTXntisduQl6Hm5J4nUQVUOoYxU+QxmO3+OF3ylvadCTYVqf0fukUUPxasIIf/YbhZLIHO98Dejq0hwPKCXuz1SPNAlg3eQpgGZWWoE1C6d7e5zC38p4NmZRoBRQpZjySCLb/vCQxOdukAMpx7Dn6py2hBAIFFAlGLCdBi3vl98D+i2BmaxVQJJaoqQnHu9plZYtFxkDyVECRVWJIRzN54Kvx2KYQk6hCw6QUUBqaxn2Eyc2Uey5/HOhAB5KnAoq/cprMjU1HkwOa/4sHlKcCitSyFEulJmeTWC6X60aNcpoNmZRoBRQpZpxIRLDP0kYjmUlapWWa/GzEN2EzU22uCii1NvET0jU+bp7nJwE3vKhNvuiG3g+tAoof69Xj5eJG7HFt+kiE3JMg+4vridCMMAUUyVbF6buP6Xr+csnJ1iQnWOFHQQCynLECStkSMv9z8WNd3/8hmUlWppXN5S4GSNZXhjX7XQGlCRZGrbLAFKOPNaNjq+uDp4uiuLcJYlsmqYBiaR4/keIUdGwf3rdv32w/qVTy9g8MfMIURdoUFbgfGwWUypKQ/I5RyVkjI6O7ULOc5DfpfsPYwAvFvzKHR0D95lfNr4BSbRHJv7G3deF4wdzdr+dupAkyt8nDfeuHs3ruN8xk29GkzXDLL4tenRSUZUkH6WD/SA7AubtDY48kk8mG53PQUY1n4d8X4LgIyW6Ca5K4g+Q9kjg7KaiA4tG8vtlwpAPNyD8AHh0bngyAoxOHu9JorrBexJcBHNL6NtayOgNK4Mvi1kJPoVghToS2JwIgDLXMkQfvEy8T/8PzL9J9FHyNZnhM2d6SRBconN+JE3OLqd1v7yIKh3aRAwqAIbimbe5LJ6+mywBiGluKXV6uvDCHw/TRkiJqQBnDAZONmVTi9rKZMXp4i/PuZegIvlAOU//lWyA6QOH8AGqPNTiu+dtqM6TTs/ZiyPkZxtkfquPUbzkWiAhQeBZAWJFKpXY0Uhs1y6FMKrmOM21rIxoV7t0CoQcK+iSv8mnxJQDCv+zUBG0hk0lsQjMUyPlfO3naKT7UQMFp/ednTO9anpk//39ujI6O7g1wPXElgKOGz24MZ0EbXqBw9iD8tH9u7ty5ns7WZlKpu+H1iKbAAzsLbGHnyEeFc2YWcyQY2Vzjt0aAa6yHdH1g0BR0xYyYE/bSoqYTc7OvYwJgN+R9WdO0N3H68D1ejO2Px8V7CxYsoJu7OLYuzC8UCvMxq4s/bZ7JRC+m/OGXlk4B8EUIx4yB3CdUQIGhoCLf3JdK3CFLTXgneh6rtisLRf4kDBn4uRs7PVCib0DvBzWNPZFIJGjt5307HsT3T/zVkO7fv3/OyMj4mUIUlyDyPABPimPjMC0KjvEYv6ze8LfGGh4CyMGvYKNPYTllkQd2qSwAw1sAyP2xGN8OcDTVGwFtduJF86vCFF+CEvNqFXG2KBgKoMBwQxoX51sNf2sVdB9y4MCBeQcPjjyOZbhAD2qVJUXn/DUM329JpXq3QWfpjgDL+dT7j+aoC3tt12EF8lr8Lf6AxhlQQtCZxRxJjFvOkXyglL838veKfstZ6OTSdsLAHuT3isa1C9E5/zjy/3XQICFFkedoXyq1HXNNZ0CejQDtHjcGaGmNQl8Y6+pc43b460bBerT4umJZI38POoBX1IuXFYbCOYQm5sZUKnEX3kM1VIcNpul67puYzV6VSafW2OncMqAAJH/pnjF9XTPdbNopn80aN6Gz9307Oi/xAMYzaE6vQHP6thf+oHioSaLaxi6/1gCFs9+hCvyyEwHtFPAbj8NaV6DPcg/VMn7TmuAfw21ZV6bTyZ9LSi8UyQQOFIDjrnQqcTX+h6YqRifvCzgrQ4uNvo5BoJYcZEJbj2UE7Jb39ui6wAbqgeUYyp+Ov4W4sHwh0k2imZyJ2m8mpYrmbBidjmGM4HKotd5ACP1h7qV3ZzrNm+J7NjCgABiCcbEFM6a3eTNhc7mwmXmpKJiPI5c6Q0j7vKHfqyi0tV6aGszz9Jom24ia7QIU/hnIzetlW3Rh1C50Vn+PeZn7sT42YC+5M4qggELV8SZUx/c7E6s1VDj4vUiwcZprOc6VBJw91xXvOM/usqbqNDFrvFIIczOqiDVo+qROfgK4BQyD4c5Uu40mHavzdvu76UCBwEPYR7Ie6H7WrXCtoN+7d2/m/bHCk6jqT3aSP77g3Z3xjlVuQGIYxipTsB8AkGhimv9Axp0aZ99Fbfdnr7k1GShcj3fwc5o9++hV+UZ8NA1+eOT9R1GQKxvRUDgK4HXOulfSxikrunLc4OBgamy8eAdqj0vKYUH+x0e7rTMeu6bkHt1lxk0DCoyIWciuc9Lpee+4lCkU5DRszBo4oSfYhfUEgn57ujrjy7BQl60XXx1mGAPnFIW5DTVVQOd1qiWY+E07Bbl2CWaHsfbl/GnKzCxVdZgjWR5VkJD58PWNYgh/Eabc764xJzxGazy+wSlI+o38NVjBfqLlICFFAFSShWSq0csiQD5QOHsIU9Vnt3IizUJfV1EAi4mh7pXoiH+nkhFr3JhtXfBiZVi9d6qVdN3YykzzdrzLt3W9TB2ElWSBTCQbyeiAhUlterjGf5JOJr5FBnaSeZRosoaBM8D8Z5B5B+aBVkNHTGs0fgxjuMc0Dz2KIe+SxlStj8FQ+m+a1r0ulZppef2cPJRjnyqq6qvaESRUnJj/uQ9GXRvv0C61Awl9pVEACelFQC7JalOzSAMKOkg7KeN2frDy+zSul7U9mWgYuZ+GvSapLCeSlWSuDKt+lwaU6oSn6u8jHVd2WdT0x7zOZVYdXKmzgVEzjmx5aQiMEcWtlp0Xl5n2ZVJY2mn89GcNadmhk34rdHit3tBZ1SiNy8BVDE2m0TxJmEY3rhQAMclOOpAu1bwKKNUW8fibZlxDMU/iUf6jbJhnKelyNODIiwJKlUG8/MTazafxNbZkWt6LvHY8pAvpVEmngFJpDY/v6Aj+0CNraNmqdVJA8VlUhjH4qaBWgX2K6oqddCLdykwKKGVLePxvmsVrPbKGnq1SNwUUH8VFO9No05GPJMLNCt1KOkJKBRQfRVXavih5Z5oPcaSzolPbQTpSwgooPsyLqe8LfLBHgrWsowKKx+Ki3fLo8NFG6LZ+SEfSVQHFczHTkQrPu+U959oCRpwIGFiugOLZ8nTuZqo84nQFFM9lLRZ6Zo0co1iogOKx0OgEn0fWyLGRrgooHosNG8iTHlkjx0a6KqB4LTacBfbKGjk+6KqA4rHUsFtoygCFdFVA8QiUqcamgOKxxEuuJzzyRo2NdFVA8Vpq8E/ilTVyfNBVAcVjqWFq2/bYhsekQ8dGuiqgeCyWI56OPDJHjI10VUDxXGjkDmuqPPwNda7Hc1mX/NV75nbKKPPcjtM8a+n4bmk1ismKidoM2jmkl47QjrWzhhO6QcfendJqFGHyG7LZ3L5YjOXbxXjwFPUiDqTXdUVO3hezurELHb0V7aJvPT0wfb+LdJUGFJwz+whm8B4p1DVrPRHCHzaxC/35RpKS90XsAGtvoEBH0l9a09PImFEON5m53kp+ctGJGqdgRRPlONKNdCQdFFAsShIzkussolnJjytcdFrRRDoOupV91UpseiJtkrrCYxf6Cfl8/lS6cKkuAQLJjysuUVrbKN5veJDeDKplJd3KYapGKVuiwf+Cyc5vEFUKJme/5NzQiiaKcaRTpSNjBRS7UjTNr6FmiVuRwdnv96zioxhHDowr5dZQd45XBqj3yRbASO5YPZ//yuTQyb/gEXoHOn7bJodG9xfpUu3lGsARenRVCkZyUWTXo1axrH3JIzQ+ugPBSNTEXKBDSZeqLEj5PVVh6meNBcRJqFU21ARXBJDbcPIIja8xsq5TSXbSoZ4LdNQodM2reuwsgFrlBrtahXyf4Tre6+zSCms8yV7PfxvJq+FK1QeBJDTF6rG2gDjFMPJXWdMwRnc24+v7pR1d2OJJZqv7pjGnhNuWdeNX8Exr2WELm2KtkAdDxsPxjtip8DX7X6v8UfPAtXl+B/lvtaILSxx5r4YP3VWoMEYbyVTqoOFSoi0gmjpb+xpZwyYcC4AzxgvFewGE0gfWiJwMTm7DqQAa0YQlnGQsyWoBEpK1BBTqvIBhgxoq2xcfrRajCfqGHSX5lqevNMzNEMlGMtr5wSddJ30ZuAd3I7rsW+EG03KCyc5IUyB+BJd6r8I6yC4nupJHaHL2a9cZdpKWDBrUeDglyq+z6pNU5zMJKBRpGHsXm6LwAJQ6oZpY/f7AAuivDKK/stSuv1LmaLuLnegeGky4nEp31MAYjq5AKxtjKv1HE9QzVjCfoutWnOhNw86ueGwRvuaWzeBS3iRDoyGwlR41NUolMRy9dReE+DwXfDWaoxXow6RR0xxTSTPl3zl/QWOJVW7uG47k5ZNuCxpAmT40NOTrImm3eYadftasWcP4Wl2vmdEOupKLzihcZxv2QpgK8mHPS6JYFJeQYz00aeQXDu6wPD3NuyDbkziKqWkWIMd65DMNe5Dh+kssJCc26Csm0fTPJK8ClDH6C8PoBgwDVLkjB9HojBEdH+nFHhJ+uBnC/R+7pXhmcTS9qQAAAABJRU5ErkJggg=="));
                    c.this.addView(imageView, layoutParams2);
                }

                @Override // com.qq.e.comm.plugin.p.b
                public void a(String str, ImageView imageView, com.qq.e.comm.plugin.p.e eVar) {
                }
            });
        }
        addView(jVar, layoutParams);
        addView(a(ab));
        ImageView imageView = new ImageView(getContext());
        imageView.setAlpha(0.6f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ak.a(getContext(), 39), ak.a(getContext(), 18));
        layoutParams2.addRule(11);
        layoutParams2.addRule(12);
        com.qq.e.comm.plugin.util.g.a(imageView, this.f.C());
        addView(imageView, layoutParams2);
        setPadding(ak.a(getContext(), 4), ak.a(getContext(), 4), ak.a(getContext(), 0), ak.a(getContext(), 0));
        setBackgroundDrawable(ap.a(ak.a(getContext(), 8), -1, 255));
        setVisibility(8);
        setOnClickListener(this);
    }

    private TextView f() {
        TextView textView = new TextView(getContext());
        int a2 = ak.a(getContext(), 2);
        int i = c;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(a2);
        textView.setLines(1);
        textView.setMaxWidth(ak.a(getContext(), 64));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setPadding(ak.a(getContext(), 4), 0, ak.a(getContext(), 4), 0);
        textView.setTextSize(2, 11.0f);
        textView.setTextColor(f12235b);
        return textView;
    }

    private void g() {
        final ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), -1, Integer.valueOf(d));
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qq.e.comm.plugin.n.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.k) {
                    return;
                }
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue instanceof Integer) {
                    int intValue = ((Integer) animatedValue).intValue();
                    int i = c.d;
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(intValue);
                    gradientDrawable.setCornerRadius(8);
                    gradientDrawable.setStroke(3, i);
                    if (c.this.i != null) {
                        c.this.i.setBackgroundDrawable(gradientDrawable);
                    }
                }
            }
        });
        ofObject.setDuration(500);
        ofObject.setInterpolator(new DecelerateInterpolator());
        final ValueAnimator ofObject2 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(d), -1);
        ofObject2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qq.e.comm.plugin.n.c.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.k) {
                    return;
                }
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue instanceof Integer) {
                    int intValue = ((Integer) animatedValue).intValue();
                    if (c.this.i != null) {
                        c.this.i.setTextColor(intValue);
                    }
                }
            }
        });
        ofObject2.setDuration(500);
        ofObject2.setInterpolator(new DecelerateInterpolator());
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.n.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.k) {
                    return;
                }
                ofObject.start();
                ofObject2.start();
            }
        }, n * 1000);
    }

    @Override // com.qq.e.comm.plugin.n.g
    public void a() {
        u.a(1140001, 1, this.l);
        setVisibility(0);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        startAnimation(translateAnimation);
        if (this.i != null) {
            g();
        }
        this.j = true;
    }

    @Override // com.qq.e.comm.plugin.n.g
    public void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    @Override // com.qq.e.comm.plugin.n.g
    public void a(ViewGroup viewGroup, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (getParent() == null) {
            if (z) {
                layoutParams = new RelativeLayout.LayoutParams(ak.a(getContext(), 359), ak.a(getContext(), 104));
                layoutParams.addRule(11, -1);
                layoutParams.addRule(12, -1);
                layoutParams.bottomMargin = ak.a(getContext(), 8);
                layoutParams.rightMargin = ak.a(getContext(), 8);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, ak.a(getContext(), 104));
                layoutParams.addRule(12, -1);
                layoutParams.addRule(14, -1);
                layoutParams.leftMargin = ak.a(getContext(), 8);
                layoutParams.bottomMargin = ak.a(getContext(), 8);
                layoutParams.rightMargin = ak.a(getContext(), 8);
            }
            viewGroup.addView(this, layoutParams);
        }
    }

    @Override // com.qq.e.comm.plugin.n.g
    public void a(com.qq.e.comm.plugin.ad.g gVar) {
        this.h = gVar;
    }

    @Override // com.qq.e.comm.plugin.n.g
    public void a(b.a aVar) {
        this.g = aVar;
    }

    @Override // com.qq.e.comm.plugin.n.g
    public boolean b() {
        return this.j;
    }

    @Override // com.qq.e.comm.plugin.n.g
    public void c() {
        if (this.i != null) {
            this.i.clearAnimation();
            this.i = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.m.a()) {
            u.a(1140002, 1, this.l);
            if (this.g != null) {
                this.g.a();
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.h != null) {
            this.h.a(motionEvent, true);
        }
        this.m.a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
