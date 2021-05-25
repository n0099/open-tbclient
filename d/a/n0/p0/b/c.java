package d.a.n0.p0.b;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.manito.ManitoMemberItemViewHolder;
import d.a.m0.z0.i0;
import d.a.n0.r0.k;
/* loaded from: classes4.dex */
public class c extends k<d, ManitoMemberItemViewHolder> {
    public View.OnClickListener w;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = (d) view.getTag();
            TiebaStatic.log("c10624");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(c.this.f39228e, dVar.k(), dVar.h(), "")));
        }
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.w = new a();
    }

    @Override // d.a.n0.r0.k, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        v0(i2, view, viewGroup, (d) obj, (ManitoMemberItemViewHolder) viewHolder);
        return view;
    }

    public final SpannableStringBuilder t0(String str, String[] strArr, int[] iArr) {
        int indexOf;
        if (str == null || strArr == null || iArr == null || strArr.length <= 0 || iArr.length <= 0 || strArr.length != iArr.length) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableString spannableString = new SpannableString(str);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (strArr[i2] != null && (indexOf = str.indexOf(strArr[i2])) >= 0) {
                spannableString.setSpan(new ForegroundColorSpan(iArr[i2]), indexOf, strArr[i2].length() + indexOf, 17);
            }
        }
        spannableStringBuilder.append((CharSequence) spannableString);
        return spannableStringBuilder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: u0 */
    public ManitoMemberItemViewHolder P(ViewGroup viewGroup) {
        return new ManitoMemberItemViewHolder(LayoutInflater.from(this.f39228e).inflate(R.layout.manito_item_member, (ViewGroup) null));
    }

    public View v0(int i2, View view, ViewGroup viewGroup, d dVar, ManitoMemberItemViewHolder manitoMemberItemViewHolder) {
        super.W(i2, view, viewGroup, dVar, manitoMemberItemViewHolder);
        if (dVar != null && manitoMemberItemViewHolder != null) {
            if (manitoMemberItemViewHolder.f14961f != this.r) {
                SkinManager.setBackgroundResource(manitoMemberItemViewHolder.a(), R.drawable.frs_member_manito_bg);
                SkinManager.setViewTextColor(manitoMemberItemViewHolder.f14957b, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(manitoMemberItemViewHolder.f14958c, R.color.CAM_X0109, 1);
                SkinManager.setBackgroundColor(manitoMemberItemViewHolder.f14960e, R.color.CAM_X0204);
                SkinManager.setViewTextColor(manitoMemberItemViewHolder.f14959d, R.color.CAM_X0109, 1);
            }
            manitoMemberItemViewHolder.f14956a.e(dVar.e(), 12, false);
            manitoMemberItemViewHolder.f14957b.setText(i0.e(dVar.i(), 16));
            if (StringUtils.isNull(dVar.f())) {
                manitoMemberItemViewHolder.f14958c.setText(R.string.god_intro_default);
            } else {
                manitoMemberItemViewHolder.f14958c.setText(i0.e(dVar.f(), 30));
            }
            int color = SkinManager.getColor(R.color.CAM_X0301);
            String numberUniformFormat = StringHelper.numberUniformFormat(dVar.c());
            manitoMemberItemViewHolder.f14959d.setText(t0(String.format(this.f39228e.getResources().getString(R.string.fans_count), numberUniformFormat), new String[]{numberUniformFormat}, new int[]{color}));
            manitoMemberItemViewHolder.a().setTag(dVar);
            manitoMemberItemViewHolder.a().setOnClickListener(this.w);
            manitoMemberItemViewHolder.f14961f = this.r;
        }
        return view;
    }
}
