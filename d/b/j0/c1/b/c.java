package d.b.j0.c1.b;

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
    public TbPageContext<?> f53899a;

    /* renamed from: b  reason: collision with root package name */
    public OvalActionButton f53900b;

    /* renamed from: c  reason: collision with root package name */
    public String f53901c;

    /* renamed from: d  reason: collision with root package name */
    public String f53902d;

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
        this.f53899a = tbPageContext;
        this.f53900b = ovalActionButton;
        ovalActionButton.setIsCircle(true);
        this.f53900b.setHasShadow(false);
        this.f53900b.setOnClickListener(new a());
    }

    public final void b() {
        if (WriteActivityConfig.isAsyncWriting() || this.f53901c == null) {
            return;
        }
        WriteActivityConfig.newInstance(this.f53899a.getPageActivity()).setType(9).setForumId("0").setTopicId(String.valueOf(this.f53901c)).setFrom("topic_detail").setCallFrom("1").setTitle(StringUtils.isNull(this.f53902d) ? null : String.format(TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_write_name), this.f53902d)).send();
    }

    public void c(String str) {
        this.f53902d = str;
    }

    public void d(String str) {
        this.f53901c = str;
    }
}
