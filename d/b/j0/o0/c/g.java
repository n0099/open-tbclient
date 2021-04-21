package d.b.j0.o0.c;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.FrsMemberHeaderViewHolder;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.b.j0.d3.w;
/* loaded from: classes4.dex */
public class g extends d.b.j0.q0.k<h, FrsMemberHeaderViewHolder> {
    public LikeModel w;
    public int x;
    public int y;
    public View.OnClickListener z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                d.b.c.j.e.n z = g.this.z(((Integer) tag).intValue());
                if (z instanceof h) {
                    h hVar = (h) z;
                    if (view.getId() == R.id.like_btn) {
                        if (ViewHelper.checkUpIsLogin(g.this.o.getPageActivity())) {
                            if (!d.b.c.e.p.j.z()) {
                                g.this.o.showToast(R.string.neterror);
                                return;
                            }
                            String a2 = hVar.a();
                            g.this.w.H(hVar.e(), a2);
                        }
                    } else if (view.getId() == R.id.user_level_name) {
                        String a3 = hVar.a();
                        g.this.o.sendMessage(new CustomMessage(2003006, new TbTitleActivityConfig(g.this.f43095e, hVar.e(), a3)));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.b.c.a.e {
        public b() {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            if (!(obj instanceof w) || g.this.w.getErrorCode() != 0) {
                if (AntiHelper.m(g.this.w.getErrorCode(), g.this.w.getErrorString())) {
                    AntiHelper.u(g.this.o.getPageActivity(), g.this.w.getErrorString());
                    return;
                } else {
                    g.this.o.showToast(g.this.w.getErrorString());
                    return;
                }
            }
            w wVar = (w) obj;
            wVar.v(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
        }
    }

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.x = 0;
        this.y = 0;
        this.z = new a();
    }

    public final int[] A0(int i) {
        return i <= 3 ? new int[]{-8331843, -10499102} : i <= 9 ? new int[]{-10499102, -154262} : i <= 15 ? new int[]{-154262, -148180} : new int[]{-148180, -100818};
    }

    public final void B0() {
        TbPageContext<?> tbPageContext = this.o;
        if (tbPageContext == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.w = likeModel;
        likeModel.setLoadDataCallBack(new b());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: C0 */
    public FrsMemberHeaderViewHolder R(ViewGroup viewGroup) {
        if (this.w == null) {
            B0();
        }
        return new FrsMemberHeaderViewHolder(LayoutInflater.from(this.f43095e).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.z);
    }

    public View D0(int i, View view, ViewGroup viewGroup, h hVar, FrsMemberHeaderViewHolder frsMemberHeaderViewHolder) {
        super.X(i, view, viewGroup, hVar, frsMemberHeaderViewHolder);
        if (hVar != null && hVar.f() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = SkinManager.getColor(R.color.CAM_X0109);
            w f2 = hVar.f();
            if (TbadkCoreApplication.isLogin()) {
                if (f2.l() == 1) {
                    frsMemberHeaderViewHolder.f15590a.setVisibility(8);
                    frsMemberHeaderViewHolder.f15591b.setVisibility(0);
                    frsMemberHeaderViewHolder.f15591b.setText(R.string.mydegree);
                    SkinManager.setImageResource(frsMemberHeaderViewHolder.f15592c, BitmapHelper.getSmallGradeResourceIdNew(f2.k()));
                    if (StringUtils.isNull(f2.h())) {
                        frsMemberHeaderViewHolder.f15593d.setVisibility(8);
                    } else {
                        frsMemberHeaderViewHolder.f15593d.setText(f2.h());
                        frsMemberHeaderViewHolder.f15593d.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(f2.c() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + f2.i());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    frsMemberHeaderViewHolder.f15596g.setText(spannableStringBuilder);
                    frsMemberHeaderViewHolder.f15596g.setVisibility(0);
                    frsMemberHeaderViewHolder.k.setVisibility(0);
                    frsMemberHeaderViewHolder.l.setVisibility(0);
                } else {
                    frsMemberHeaderViewHolder.f15590a.setVisibility(0);
                    frsMemberHeaderViewHolder.f15591b.setVisibility(8);
                    frsMemberHeaderViewHolder.f15592c.setVisibility(8);
                    frsMemberHeaderViewHolder.f15593d.setVisibility(8);
                    frsMemberHeaderViewHolder.f15596g.setVisibility(8);
                    frsMemberHeaderViewHolder.k.setVisibility(8);
                    frsMemberHeaderViewHolder.l.setVisibility(8);
                }
            } else {
                frsMemberHeaderViewHolder.f15590a.setVisibility(8);
                frsMemberHeaderViewHolder.f15591b.setVisibility(8);
                frsMemberHeaderViewHolder.f15592c.setVisibility(8);
                frsMemberHeaderViewHolder.f15593d.setVisibility(8);
                frsMemberHeaderViewHolder.f15596g.setVisibility(8);
                frsMemberHeaderViewHolder.k.setVisibility(8);
                frsMemberHeaderViewHolder.l.setVisibility(8);
            }
            frsMemberHeaderViewHolder.f15590a.setTag(Integer.valueOf(i));
            frsMemberHeaderViewHolder.f15593d.setTag(Integer.valueOf(i));
            frsMemberHeaderViewHolder.f15593d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.f15597h, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.f15594e, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.i, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(frsMemberHeaderViewHolder.f15590a, R.drawable.frs_btn_like);
            SkinManager.setViewTextColor(frsMemberHeaderViewHolder.f15590a, R.color.white_alpha100, 1);
            SkinManager.setViewTextColor(frsMemberHeaderViewHolder.f15591b, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(frsMemberHeaderViewHolder.f15593d, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(frsMemberHeaderViewHolder.j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(frsMemberHeaderViewHolder.k, R.drawable.forum_member_exp_progress);
            SkinManager.setBackgroundColor(frsMemberHeaderViewHolder.l, R.color.CAM_X0204);
            if (this.x != f2.k() || this.y != f2.c()) {
                this.x = f2.k();
                this.y = f2.c();
                frsMemberHeaderViewHolder.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, A0(this.x)));
                int c2 = f2.c();
                this.y = c2;
                if (c2 > f2.i()) {
                    this.y = f2.i();
                }
                float i2 = f2.i() != 0 ? this.y / f2.i() : 0.0f;
                if (i2 > 0.999f) {
                    i2 = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, i2, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                d.b.j0.d3.a.b((TbPageContextSupport) this.o.getPageActivity(), frsMemberHeaderViewHolder.k, scaleAnimation, null);
            }
        }
        return view;
    }

    @Override // d.b.j0.q0.k, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        D0(i, view, viewGroup, (h) obj, (FrsMemberHeaderViewHolder) viewHolder);
        return view;
    }
}
