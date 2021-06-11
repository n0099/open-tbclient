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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(c.this.f42909e, dVar.i(), dVar.g(), "")));
        }
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.w = new a();
    }

    @Override // d.a.n0.r0.k, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        w0(i2, view, viewGroup, (d) obj, (ManitoMemberItemViewHolder) viewHolder);
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
    @Override // d.a.c.k.e.a
    /* renamed from: v0 */
    public ManitoMemberItemViewHolder Q(ViewGroup viewGroup) {
        return new ManitoMemberItemViewHolder(LayoutInflater.from(this.f42909e).inflate(R.layout.manito_item_member, (ViewGroup) null));
    }

    public View w0(int i2, View view, ViewGroup viewGroup, d dVar, ManitoMemberItemViewHolder manitoMemberItemViewHolder) {
        super.X(i2, view, viewGroup, dVar, manitoMemberItemViewHolder);
        if (dVar != null && manitoMemberItemViewHolder != null) {
            if (manitoMemberItemViewHolder.f15018f != this.r) {
                SkinManager.setBackgroundResource(manitoMemberItemViewHolder.a(), R.drawable.frs_member_manito_bg);
                SkinManager.setViewTextColor(manitoMemberItemViewHolder.f15014b, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(manitoMemberItemViewHolder.f15015c, R.color.CAM_X0109, 1);
                SkinManager.setBackgroundColor(manitoMemberItemViewHolder.f15017e, R.color.CAM_X0204);
                SkinManager.setViewTextColor(manitoMemberItemViewHolder.f15016d, R.color.CAM_X0109, 1);
            }
            manitoMemberItemViewHolder.f15013a.e(dVar.c(), 12, false);
            manitoMemberItemViewHolder.f15014b.setText(i0.e(dVar.h(), 16));
            if (StringUtils.isNull(dVar.e())) {
                manitoMemberItemViewHolder.f15015c.setText(R.string.god_intro_default);
            } else {
                manitoMemberItemViewHolder.f15015c.setText(i0.e(dVar.e(), 30));
            }
            int color = SkinManager.getColor(R.color.CAM_X0301);
            String numberUniformFormat = StringHelper.numberUniformFormat(dVar.b());
            manitoMemberItemViewHolder.f15016d.setText(t0(String.format(this.f42909e.getResources().getString(R.string.fans_count), numberUniformFormat), new String[]{numberUniformFormat}, new int[]{color}));
            manitoMemberItemViewHolder.a().setTag(dVar);
            manitoMemberItemViewHolder.a().setOnClickListener(this.w);
            manitoMemberItemViewHolder.f15018f = this.r;
        }
        return view;
    }
}
