package d.a.n0.o2;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.n0.o2.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f57881e;

    /* renamed from: g  reason: collision with root package name */
    public int f57883g = -1;

    /* renamed from: f  reason: collision with root package name */
    public List<b.a> f57882f = new ArrayList();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f57884e;

        public a(b.a aVar) {
            this.f57884e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f57881e == null) {
                return;
            }
            e.this.e(this.f57884e);
            if (this.f57884e.f57853g == 1) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(e.this.f57881e.getPageActivity()).createSubPbActivityConfig(this.f57884e.f57852f + "", this.f57884e.f57847a + "", "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                e.this.f57881e.sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(e.this.f57881e.getPageActivity()).createNormalCfg(this.f57884e.f57852f + "", this.f57884e.f57847a + "", "search_post");
            createNormalCfg.setStartFrom(8);
            createNormalCfg.setSortType(0);
            e.this.f57881e.sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f57886a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f57887b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f57888c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f57889d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f57890e;

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        TbadkCoreApplication.getInst().getListItemRule().c();
    }

    public e(TbPageContext<?> tbPageContext) {
        this.f57881e = tbPageContext;
    }

    public void c(List<b.a> list) {
        this.f57882f = list;
    }

    public void d(int i2) {
        this.f57883g = i2;
    }

    public final void e(b.a aVar) {
        StatisticItem param = new StatisticItem("c12405").param("fname", aVar.f57851e).param("uid", TbadkCoreApplication.getCurrentAccount());
        int i2 = this.f57883g;
        if (i2 > 0) {
            param.param("tab_id", i2);
        }
        if (aVar != null) {
            if (aVar.f57853g != 1 && aVar.f57854h != 1) {
                param.param("tid", aVar.f57852f);
            } else {
                param.param("pid", aVar.f57847a);
            }
        }
        TiebaStatic.log(param);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<b.a> list = this.f57882f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<b.a> list = this.f57882f;
        if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f57882f.size()) {
            return null;
        }
        return this.f57882f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f57881e.getPageActivity()).inflate(R.layout.post_search_list_item, (ViewGroup) null);
            b bVar = new b(null);
            bVar.f57886a = (TextView) view.findViewById(R.id.title_text);
            bVar.f57887b = (TextView) view.findViewById(R.id.content_text);
            bVar.f57888c = (TextView) view.findViewById(R.id.label_text);
            bVar.f57889d = (TextView) view.findViewById(R.id.user_name);
            bVar.f57890e = (TextView) view.findViewById(R.id.time_text);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        b.a aVar = this.f57882f.get(i2);
        if (aVar == null) {
            return view;
        }
        String str = TbadkCoreApplication.getInst().getSkinType() == 1 ? "#99260f" : "#e53917";
        bVar2.f57886a.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.f57848b, str)));
        bVar2.f57887b.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.f57850d, str)));
        bVar2.f57889d.setText(aVar.f57855i);
        bVar2.f57890e.setText(StringHelper.getFormatTime(aVar.f57849c));
        bVar2.f57888c.setVisibility(0);
        if (aVar.f57853g == 1) {
            bVar2.f57888c.setText(R.string.floor_text);
        } else if (aVar.f57854h == 1) {
            bVar2.f57888c.setText(R.string.reply_post);
        } else {
            bVar2.f57888c.setVisibility(8);
        }
        view.setOnClickListener(new a(aVar));
        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        d.a.m0.s0.a.a(this.f57881e, view);
        return view;
    }
}
