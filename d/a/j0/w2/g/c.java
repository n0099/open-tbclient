package d.a.j0.w2.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import d.a.c.e.p.l;
import d.a.j0.d2.h.m;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends d {
    public m C;
    public View D;
    public View E;
    public View F;
    public View G;
    public TbImageView H;
    public LinearLayout I;
    public TbImageView J;
    public TextView K;
    public View L;
    public ImageView M;
    public TextView N;
    public TextView O;
    public TbImageView P;
    public View Q;
    public TextView R;
    public TextView S;
    public LinearLayout T;
    public PlayVoiceBntNew U;

    public c(Context context, boolean z, int i2, m mVar) {
        super(context, z, i2);
        this.C = mVar;
        this.D = this.f62423f.findViewById(R.id.pb_post_share_root_view);
        this.E = this.f62423f.findViewById(R.id.pb_post_share_card_container);
        this.F = this.f62423f.findViewById(R.id.pb_post_share_card);
        this.G = this.f62423f.findViewById(R.id.pb_post_share_card_content);
        this.H = (TbImageView) this.f62423f.findViewById(R.id.pb_post_share_title);
        this.I = (LinearLayout) this.f62423f.findViewById(R.id.pb_share_thread_container);
        TbImageView tbImageView = (TbImageView) this.f62423f.findViewById(R.id.pb_share_origin_thread_img);
        this.J = tbImageView;
        tbImageView.setPlaceHolder(2);
        this.J.setConrers(15);
        this.J.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.J.setGifIconSupport(false);
        this.J.setLongIconSupport(false);
        this.K = (TextView) this.f62423f.findViewById(R.id.origin_thread_abstract);
        this.L = this.f62423f.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.M = (ImageView) this.f62423f.findViewById(R.id.pb_post_share_video_play_iv);
        this.N = (TextView) this.f62423f.findViewById(R.id.post_share_screen_shot_title);
        this.O = (TextView) this.f62423f.findViewById(R.id.post_share_qcode_comment);
        this.P = (TbImageView) this.f62423f.findViewById(R.id.post_share_qcode);
        this.Q = this.f62423f.findViewById(R.id.post_share_reply_user_id_guide_line);
        this.R = (TextView) this.f62423f.findViewById(R.id.post_share_reply_user_id);
        this.S = (TextView) this.f62423f.findViewById(R.id.post_share_comment_text);
        this.T = (LinearLayout) this.f62423f.findViewById(R.id.post_share_comment_image_container);
        this.U = (PlayVoiceBntNew) this.f62423f.findViewById(R.id.post_share_comment_voice);
        d0(context, mVar.c().K());
        i0();
        N(2);
    }

    @Override // d.a.j0.w2.g.d
    public void P(Window window) {
        window.setLayout(-1, -1);
    }

    @Override // d.a.j0.w2.g.d
    public void R() {
        if (this.C == null) {
            return;
        }
        this.D.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds31);
        View view = this.G;
        int i2 = R.color.CAM_X0211;
        SkinManager.setBackgroundShapeDrawable(view, g2, i2, i2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0206));
        this.I.setBackgroundDrawable(gradientDrawable);
        SkinManager.setViewTextColor(this.K, R.color.CAM_X0107);
        this.K.setText(this.C.b());
        e0();
        SkinManager.setBackgroundColor(this.Q, R.color.CAM_X0109);
        String name_show = this.C.c().t().getName_show();
        if (name_show.length() > 10) {
            name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
        }
        this.R.setText(name_show);
        SkinManager.setViewTextColor(this.R, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.N, R.color.CAM_X0304);
        SkinManager.setViewTextColor(this.O, R.color.CAM_X0105);
        this.P.setImageBitmap(this.C.d());
        SkinManager.setImageResource(this.H, R.drawable.pic_pb_post_share_logo);
        O(false);
        super.R();
    }

    public final void b0(Context context, List<TbRichTextImageInfo> list) {
        int i2 = 0;
        while (i2 < list.size() && i2 != 9) {
            this.T.addView(f0(context, g0(list.get(i2), this.C.a()), list.get(i2), i2 == 0, this.C.a().r));
            i2++;
        }
    }

    public void d0(Context context, TbRichText tbRichText) {
        if (tbRichText == null || tbRichText.u() == null || tbRichText.u().isEmpty()) {
            return;
        }
        Iterator<TbRichTextData> it = tbRichText.u().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                int type = next.getType();
                if (type != 1) {
                    if (type == 512) {
                        this.U.setVoiceModel((VoiceData$VoiceModel) next.E().u());
                        if (this.S.getVisibility() == 0 || this.T.getVisibility() == 0) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.U.getLayoutParams();
                            if (this.S.getVisibility() == 0 && this.T.getVisibility() == 8) {
                                layoutParams.topMargin = l.g(context, R.dimen.tbds39);
                            } else {
                                layoutParams.topMargin = l.g(context, R.dimen.tbds42);
                            }
                            this.U.setLayoutParams(layoutParams);
                        }
                        this.U.setVisibility(0);
                    }
                } else if (this.S.getVisibility() == 8) {
                    SkinManager.setViewTextColor(this.S, R.color.CAM_X0105);
                    this.S.setText(next.A());
                    this.S.setVisibility(0);
                }
            }
        }
        if (tbRichText.w().isEmpty()) {
            return;
        }
        if (this.S.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.T.getLayoutParams();
            layoutParams2.topMargin = l.g(context, R.dimen.tbds37);
            this.T.setLayoutParams(layoutParams2);
        }
        this.T.setVisibility(0);
        b0(context, tbRichText.w());
    }

    public final void e0() {
        int f2 = this.C.f();
        if (f2 == 0) {
            if (!StringUtils.isNull(this.C.e())) {
                this.J.V(this.C.e(), 10, false);
                return;
            }
            this.J.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_article_thread));
            this.J.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else if (f2 == 11) {
            this.J.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voice_thread));
            this.J.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else if (f2 != 40) {
        } else {
            this.L.setVisibility(0);
            this.M.setVisibility(0);
            this.M.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voide_thread_play));
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0604).cornerRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10)).into(this.L);
            this.J.V(this.C.e(), 10, false);
        }
    }

    public final TbImageView f0(Context context, String str, TbRichTextImageInfo tbRichTextImageInfo, boolean z, boolean z2) {
        int[] j0 = j0(tbRichTextImageInfo.getWidth(), tbRichTextImageInfo.getHeight(), l.g(TbadkCoreApplication.getInst(), R.dimen.tbds981));
        TbImageView tbImageView = new TbImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(j0[0], j0[1]);
        if (!z) {
            layoutParams.setMargins(0, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20), 0, 0);
        }
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (tbRichTextImageInfo.A()) {
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(true);
        }
        tbImageView.setConrers(15);
        tbImageView.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        tbImageView.V(str, z2 ? 17 : 18, false);
        return tbImageView;
    }

    public final String g0(TbRichTextImageInfo tbRichTextImageInfo, d.a.i0.b1.m.a aVar) {
        return aVar.c() ? tbRichTextImageInfo.s() : tbRichTextImageInfo.u();
    }

    public final Bitmap h0(View view) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(SkinManager.getColor(R.color.CAM_X0206));
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public final void i0() {
    }

    public final int[] j0(int i2, int i3, int i4) {
        int[] iArr = new int[2];
        iArr[0] = i4;
        float f2 = (i2 * 1.0f) / (i4 * 1.0f);
        iArr[1] = (int) (f2 <= 1.0f ? i3 / f2 : i3 * f2);
        return iArr;
    }

    @Override // d.a.j0.w2.g.d
    public View p() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    @Override // d.a.j0.w2.g.d
    public ShareItem r(int i2) {
        ShareItem shareItem = this.r.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.c0 = false;
        shareItem.b0 = false;
        shareItem.s = "";
        shareItem.W = 1;
        shareItem.i(h0(this.E));
        shareItem.g();
        this.r.put(1, shareItem);
        return super.r(i2);
    }
}
