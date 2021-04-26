package d.a.j0.c1.b;

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
    public TbPageContext<?> f51656a;

    /* renamed from: b  reason: collision with root package name */
    public OvalActionButton f51657b;

    /* renamed from: c  reason: collision with root package name */
    public String f51658c;

    /* renamed from: d  reason: collision with root package name */
    public String f51659d;

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
        this.f51656a = tbPageContext;
        this.f51657b = ovalActionButton;
        ovalActionButton.setIsCircle(true);
        this.f51657b.setHasShadow(false);
        this.f51657b.setOnClickListener(new a());
    }

    public final void b() {
        if (WriteActivityConfig.isAsyncWriting() || this.f51658c == null) {
            return;
        }
        WriteActivityConfig.newInstance(this.f51656a.getPageActivity()).setType(9).setForumId("0").setTopicId(String.valueOf(this.f51658c)).setFrom("topic_detail").setCallFrom("1").setTitle(StringUtils.isNull(this.f51659d) ? null : String.format(TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_write_name), this.f51659d)).send();
    }

    public void c(String str) {
        this.f51659d = str;
    }

    public void d(String str) {
        this.f51658c = str;
    }
}
