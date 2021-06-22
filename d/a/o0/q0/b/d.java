package d.a.o0.q0.b;

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
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62089a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f62090b;

    /* renamed from: c  reason: collision with root package name */
    public b f62091c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.c.g.a f62092d;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.hasError() || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != d.this.f62090b) {
                if (d.this.f62091c != null) {
                    d.this.f62091c.a(false, null);
                    return;
                }
                return;
            }
            d.a.o0.q0.c.c searchData = responsedMessage instanceof SearchPostForumHttpResponseMessage ? ((SearchPostForumHttpResponseMessage) responsedMessage).getSearchData() : null;
            if (responsedMessage instanceof SearchPostForumSocketResponseMessage) {
                searchData = ((SearchPostForumSocketResponseMessage) responsedMessage).getSearchData();
            }
            if (d.this.f62091c != null) {
                d.this.f62091c.a(searchData != null, searchData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, d.a.o0.q0.c.c cVar);
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        a aVar = new a(CmdConfigHttp.CMD_SEARCH_POST_FORUM, 309466);
        this.f62092d = aVar;
        this.f62089a = tbPageContext;
        this.f62090b = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f62092d);
    }

    public void c() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_SEARCH_POST_FORUM, this.f62090b);
    }

    public void d(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (!l.D()) {
            this.f62089a.showToast(R.string.neterror);
            return;
        }
        c();
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_SEARCH_POST_FORUM, this.f62090b);
        SearchPostForumRequestMessage searchPostForumRequestMessage = new SearchPostForumRequestMessage();
        searchPostForumRequestMessage.setTag(this.f62090b);
        searchPostForumRequestMessage.set_word(str);
        MessageManager.getInstance().sendMessage(searchPostForumRequestMessage);
    }

    public void e(b bVar) {
        this.f62091c = bVar;
    }
}
