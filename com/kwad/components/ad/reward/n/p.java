package com.kwad.components.ad.reward.n;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class p extends s implements View.OnClickListener {
    public com.kwad.components.ad.reward.g qn;
    public ImageView zR;
    public TextView zS;
    public TextView zT;
    public TextView zU;
    public TextView zV;
    public TextView zW;
    public TextView zX;
    public TextView zY;

    public p(com.kwad.components.ad.reward.g gVar) {
        this.qn = gVar;
    }

    private void b(AdTemplate adTemplate) {
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        KSImageLoader.loadCircleIcon(this.zR, com.kwad.sdk.core.response.b.a.cf(dP), this.zR.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e7e));
        this.zS.setText(com.kwad.sdk.core.response.b.a.cc(dP));
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        b(rVar.getAdTemplate());
    }

    public final void h(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.obfuscated_res_0x7f091472, R.id.obfuscated_res_0x7f0913bf);
        initView();
    }

    private void initView() {
        ViewGroup viewGroup = this.sy;
        if (viewGroup == null) {
            return;
        }
        this.zR = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0913bc);
        this.zS = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f091314);
        this.zT = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f0913ba);
        this.zU = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f0913b9);
        this.zV = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f0913bb);
        this.zW = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f0913b7);
        this.zX = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f0913b4);
        this.zY = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f0913b5);
        this.zX.setOnClickListener(this);
        this.zY.setOnClickListener(this);
    }

    public static String m(long j) {
        long j2 = j / 3600000;
        long j3 = (j / 60000) - (j2 * 60);
        long j4 = ((j / 1000) - (60 * j3)) - (3600 * j2);
        if (j2 > 0) {
            return String.format("%02d:%02d:%02d", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
        }
        return String.format("%02d:%02d", Long.valueOf(j3), Long.valueOf(j4));
    }

    public final void T(int i) {
        TextView textView = this.zW;
        if (textView != null && i > 0) {
            if (this.qn.oX) {
                String format = String.format("再停留%s秒，即可获得奖励", Integer.valueOf(i));
                SpannableString spannableString = new SpannableString(format);
                int color = gD().getResources().getColor(R.color.obfuscated_res_0x7f0607a6);
                spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
                int length = format.length();
                spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
                this.zW.setText(spannableString);
                return;
            }
            textView.setText("已获得奖励");
        }
    }

    public final void a(com.kwad.components.ad.reward.g gVar, AdLiveEndResultData.AdLivePushEndInfo adLivePushEndInfo, long j) {
        this.zU.setText(adLivePushEndInfo.mDisplayLikeUserCount);
        this.zV.setText(m(adLivePushEndInfo.mLiveDuration));
        this.zT.setText(adLivePushEndInfo.mDisplayWatchingUserCount);
        if (gVar.oX) {
            String format = String.format("再停留%s秒，即可获得奖励", Integer.valueOf((int) (Math.max(com.kwad.sdk.core.response.b.a.ag(com.kwad.sdk.core.response.b.e.dP(gVar.mAdTemplate)) - j, 0L) / 1000)));
            SpannableString spannableString = new SpannableString(format);
            int color = gD().getResources().getColor(R.color.obfuscated_res_0x7f0607a6);
            spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = format.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.zW.setText(spannableString);
            return;
        }
        this.zW.setText("内容很精彩，不要错过哦");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        com.kwad.sdk.core.report.j jVar = new com.kwad.sdk.core.report.j();
        jVar.cJ(24);
        if (view2.equals(this.zX)) {
            this.qn.a(2, view2.getContext(), 38, 1, 0L, false, jVar);
        } else if (view2.equals(this.zY)) {
            this.qn.a(2, view2.getContext(), 37, 1, 0L, false, jVar);
        }
    }
}
