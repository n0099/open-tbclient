package d.b.j0.t.d.b.a;

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
public class a extends d.b.c.j.e.a<d.b.j0.t.d.b.b.b, SquareLiveCategoryViewHolder> {
    public IAlaSquareTabController m;

    /* renamed from: d.b.j0.t.d.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1614a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.t.d.b.b.b f62228e;

        public View$OnClickListenerC1614a(d.b.j0.t.d.b.b.b bVar) {
            this.f62228e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.m != null) {
                int tabIndex = a.this.m.getTabIndex(this.f62228e.f62243e);
                if (tabIndex >= 0) {
                    a.this.m.goToTab(tabIndex);
                    return;
                } else {
                    a.this.j0(this.f62228e);
                    return;
                }
            }
            a.this.j0(this.f62228e);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    public final void j0(d.b.j0.t.d.b.b.b bVar) {
        Context context = this.f43095e;
        String str = bVar.f62246h;
        String str2 = bVar.f62244f;
        String str3 = bVar.f62245g;
        List<String> list = bVar.i;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaNewSquareSubListActivityConfig(context, str, str2, str3, (list == null || !(list instanceof ArrayList)) ? null : (ArrayList) list)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public SquareLiveCategoryViewHolder R(ViewGroup viewGroup) {
        return new SquareLiveCategoryViewHolder(LayoutInflater.from(this.f43095e).inflate(R.layout.square_live_category_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.t.d.b.b.b bVar, SquareLiveCategoryViewHolder squareLiveCategoryViewHolder) {
        View findViewById = squareLiveCategoryViewHolder.f14388a.findViewById(R.id.live_category_top_line);
        TextView textView = (TextView) squareLiveCategoryViewHolder.f14388a.findViewById(R.id.live_category_entry_name);
        TextView textView2 = (TextView) squareLiveCategoryViewHolder.f14388a.findViewById(R.id.live_category_entry_tv);
        ImageView imageView = (ImageView) squareLiveCategoryViewHolder.f14388a.findViewById(R.id.live_category_entry_img);
        if (i == 0) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(squareLiveCategoryViewHolder.f14388a, R.color.CAM_X0201);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0109);
        SkinManager.setImageResource(imageView, R.drawable.icon_arrow_tab);
        textView.setText(!TextUtils.isEmpty(bVar.f62245g) ? bVar.f62245g : bVar.f62244f);
        textView2.setOnClickListener(new View$OnClickListenerC1614a(bVar));
        return squareLiveCategoryViewHolder.a();
    }

    public void n0(IAlaSquareTabController iAlaSquareTabController) {
        this.m = iAlaSquareTabController;
    }
}
