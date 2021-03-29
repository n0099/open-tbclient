package d.b.i0.m2;

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
import d.b.i0.m2.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f56923e;

    /* renamed from: g  reason: collision with root package name */
    public int f56925g = -1;

    /* renamed from: f  reason: collision with root package name */
    public List<b.a> f56924f = new ArrayList();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f56926e;

        public a(b.a aVar) {
            this.f56926e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f56923e == null) {
                return;
            }
            e.this.e(this.f56926e);
            if (this.f56926e.f56898g == 1) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(e.this.f56923e.getPageActivity()).createSubPbActivityConfig(this.f56926e.f56897f + "", this.f56926e.f56892a + "", "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                e.this.f56923e.sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(e.this.f56923e.getPageActivity()).createNormalCfg(this.f56926e.f56897f + "", this.f56926e.f56892a + "", "search_post");
            createNormalCfg.setStartFrom(8);
            createNormalCfg.setSortType(0);
            e.this.f56923e.sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56928a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56929b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f56930c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f56931d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f56932e;

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
        this.f56923e = tbPageContext;
    }

    public void c(List<b.a> list) {
        this.f56924f = list;
    }

    public void d(int i) {
        this.f56925g = i;
    }

    public final void e(b.a aVar) {
        StatisticItem param = new StatisticItem("c12405").param("fname", aVar.f56896e).param("uid", TbadkCoreApplication.getCurrentAccount());
        int i = this.f56925g;
        if (i > 0) {
            param.param("tab_id", i);
        }
        if (aVar != null) {
            if (aVar.f56898g != 1 && aVar.f56899h != 1) {
                param.param("tid", aVar.f56897f);
            } else {
                param.param("pid", aVar.f56892a);
            }
        }
        TiebaStatic.log(param);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<b.a> list = this.f56924f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<b.a> list = this.f56924f;
        if (list == null || list.isEmpty() || i < 0 || i >= this.f56924f.size()) {
            return null;
        }
        return this.f56924f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f56923e.getPageActivity()).inflate(R.layout.post_search_list_item, (ViewGroup) null);
            b bVar = new b(null);
            bVar.f56928a = (TextView) view.findViewById(R.id.title_text);
            bVar.f56929b = (TextView) view.findViewById(R.id.content_text);
            bVar.f56930c = (TextView) view.findViewById(R.id.label_text);
            bVar.f56931d = (TextView) view.findViewById(R.id.user_name);
            bVar.f56932e = (TextView) view.findViewById(R.id.time_text);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        b.a aVar = this.f56924f.get(i);
        if (aVar == null) {
            return view;
        }
        String str = TbadkCoreApplication.getInst().getSkinType() == 1 ? "#99260f" : "#e53917";
        bVar2.f56928a.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.f56893b, str)));
        bVar2.f56929b.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.f56895d, str)));
        bVar2.f56931d.setText(aVar.i);
        bVar2.f56932e.setText(StringHelper.getFormatTime(aVar.f56894c));
        bVar2.f56930c.setVisibility(0);
        if (aVar.f56898g == 1) {
            bVar2.f56930c.setText(R.string.floor_text);
        } else if (aVar.f56899h == 1) {
            bVar2.f56930c.setText(R.string.reply_post);
        } else {
            bVar2.f56930c.setVisibility(8);
        }
        view.setOnClickListener(new a(aVar));
        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        d.b.h0.s0.a.a(this.f56923e, view);
        return view;
    }
}
