package d.a.n0.d1.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f56224a;

    /* renamed from: b  reason: collision with root package name */
    public OvalActionButton f56225b;

    /* renamed from: c  reason: collision with root package name */
    public String f56226c;

    /* renamed from: d  reason: collision with root package name */
    public String f56227d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.b();
        }
    }

    public c(OvalActionButton ovalActionButton, TbPageContext<?> tbPageContext) {
        this.f56224a = tbPageContext;
        this.f56225b = ovalActionButton;
        ovalActionButton.setIsCircle(true);
        this.f56225b.setHasShadow(false);
        this.f56225b.setOnClickListener(new a());
    }

    public final void b() {
        if (WriteActivityConfig.isAsyncWriting() || this.f56226c == null) {
            return;
        }
        WriteActivityConfig.newInstance(this.f56224a.getPageActivity()).setType(9).setForumId("0").setTopicId(String.valueOf(this.f56226c)).setFrom("topic_detail").setCallFrom("1").setTitle(StringUtils.isNull(this.f56227d) ? null : String.format(TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_write_name), this.f56227d)).send();
    }

    public void c(String str) {
        this.f56227d = str;
    }

    public void d(String str) {
        this.f56226c = str;
    }
}
