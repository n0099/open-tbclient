package d.a.n0.v.d.b.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.holder.SquareLiveCategoryViewHolder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends d.a.c.j.e.a<d.a.n0.v.d.b.b.b, SquareLiveCategoryViewHolder> {
    public IAlaSquareTabController m;

    /* renamed from: d.a.n0.v.d.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1639a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.v.d.b.b.b f61419e;

        public View$OnClickListenerC1639a(d.a.n0.v.d.b.b.b bVar) {
            this.f61419e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.m != null) {
                int tabIndex = a.this.m.getTabIndex(this.f61419e.f61434e);
                if (tabIndex >= 0) {
                    a.this.m.goToTab(tabIndex);
                    return;
                } else {
                    a.this.g0(this.f61419e);
                    return;
                }
            }
            a.this.g0(this.f61419e);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    public final void g0(d.a.n0.v.d.b.b.b bVar) {
        Context context = this.f39228e;
        String str = bVar.f61437h;
        String str2 = bVar.f61435f;
        String str3 = bVar.f61436g;
        List<String> list = bVar.f61438i;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaNewSquareSubListActivityConfig(context, str, str2, str3, (list == null || !(list instanceof ArrayList)) ? null : (ArrayList) list)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public SquareLiveCategoryViewHolder P(ViewGroup viewGroup) {
        return new SquareLiveCategoryViewHolder(LayoutInflater.from(this.f39228e).inflate(R.layout.square_live_category_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.v.d.b.b.b bVar, SquareLiveCategoryViewHolder squareLiveCategoryViewHolder) {
        View findViewById = squareLiveCategoryViewHolder.f13665a.findViewById(R.id.live_category_top_line);
        TextView textView = (TextView) squareLiveCategoryViewHolder.f13665a.findViewById(R.id.live_category_entry_name);
        TextView textView2 = (TextView) squareLiveCategoryViewHolder.f13665a.findViewById(R.id.live_category_entry_tv);
        ImageView imageView = (ImageView) squareLiveCategoryViewHolder.f13665a.findViewById(R.id.live_category_entry_img);
        if (i2 == 0) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(squareLiveCategoryViewHolder.f13665a, R.color.CAM_X0201);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0109);
        SkinManager.setImageResource(imageView, R.drawable.icon_arrow_tab);
        textView.setText(!TextUtils.isEmpty(bVar.f61436g) ? bVar.f61436g : bVar.f61435f);
        textView2.setOnClickListener(new View$OnClickListenerC1639a(bVar));
        return squareLiveCategoryViewHolder.a();
    }

    public void j0(IAlaSquareTabController iAlaSquareTabController) {
        this.m = iAlaSquareTabController;
    }
}
