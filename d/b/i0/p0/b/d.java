package d.b.i0.p0.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.forumsearch.message.SearchPostForumHttpResponseMessage;
import com.baidu.tieba.forumsearch.message.SearchPostForumRequestMessage;
import com.baidu.tieba.forumsearch.message.SearchPostForumSocketResponseMessage;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58880a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f58881b;

    /* renamed from: c  reason: collision with root package name */
    public b f58882c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.c.c.g.a f58883d;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.hasError() || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != d.this.f58881b) {
                if (d.this.f58882c != null) {
                    d.this.f58882c.a(false, null);
                    return;
                }
                return;
            }
            d.b.i0.p0.c.c searchData = responsedMessage instanceof SearchPostForumHttpResponseMessage ? ((SearchPostForumHttpResponseMessage) responsedMessage).getSearchData() : null;
            if (responsedMessage instanceof SearchPostForumSocketResponseMessage) {
                searchData = ((SearchPostForumSocketResponseMessage) responsedMessage).getSearchData();
            }
            if (d.this.f58882c != null) {
                d.this.f58882c.a(searchData != null, searchData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, d.b.i0.p0.c.c cVar);
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        a aVar = new a(CmdConfigHttp.CMD_SEARCH_POST_FORUM, 309466);
        this.f58883d = aVar;
        this.f58880a = tbPageContext;
        this.f58881b = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f58883d);
    }

    public void c() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_SEARCH_POST_FORUM, this.f58881b);
    }

    public void d(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (!l.C()) {
            this.f58880a.showToast(R.string.neterror);
            return;
        }
        c();
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_SEARCH_POST_FORUM, this.f58881b);
        SearchPostForumRequestMessage searchPostForumRequestMessage = new SearchPostForumRequestMessage();
        searchPostForumRequestMessage.setTag(this.f58881b);
        searchPostForumRequestMessage.set_word(str);
        MessageManager.getInstance().sendMessage(searchPostForumRequestMessage);
    }

    public void e(b bVar) {
        this.f58882c = bVar;
    }
}
