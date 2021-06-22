package d.a.o0.p0.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.forumMember.bawu.BawuTeamHttpResponseMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamInfoReadCacheRequestMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamReadCacheResponseMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamRequestMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamSocketResponseMessage;
import d.a.o0.p0.c.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BawuRoleDes;
import tbclient.BawuRoleInfoPub;
import tbclient.BawuTeam;
import tbclient.GetBawuInfo.ManagerApplyInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public BawuTeam f61759a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61760b;

    /* renamed from: c  reason: collision with root package name */
    public ManagerApplyInfo f61761c;

    /* renamed from: d  reason: collision with root package name */
    public c f61762d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f61763e = new a(CmdConfigHttp.BAWU_TEAM_INFO_CMD, 301007);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f61764f = new b(2003005);

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BawuTeamHttpResponseMessage;
            if (z || (responsedMessage instanceof BawuTeamSocketResponseMessage)) {
                if (z) {
                    BawuTeamHttpResponseMessage bawuTeamHttpResponseMessage = (BawuTeamHttpResponseMessage) responsedMessage;
                    e.this.f61759a = bawuTeamHttpResponseMessage.getBawuTeamInfo();
                    e.this.f61760b = bawuTeamHttpResponseMessage.isPrivateForum() != 0;
                    e.this.f61761c = bawuTeamHttpResponseMessage.getManagerApplyInfo();
                } else if (responsedMessage instanceof BawuTeamSocketResponseMessage) {
                    BawuTeamSocketResponseMessage bawuTeamSocketResponseMessage = (BawuTeamSocketResponseMessage) responsedMessage;
                    e.this.f61759a = bawuTeamSocketResponseMessage.getBawuTeamInfo();
                    e.this.f61760b = bawuTeamSocketResponseMessage.isPrivateForum() != 0;
                    e.this.f61761c = bawuTeamSocketResponseMessage.getManagerApplyInfo();
                }
                l lVar = new l();
                if (e.this.f61761c != null) {
                    lVar.l(e.this.f61761c.manager_left_num.intValue());
                    lVar.k(e.this.f61761c.manager_apply_url);
                    lVar.h(e.this.f61761c.assist_left_num.intValue());
                    lVar.g(e.this.f61761c.assist_apply_url);
                }
                if (e.this.f61762d != null) {
                    c cVar = e.this.f61762d;
                    e eVar = e.this;
                    cVar.a(eVar.j(eVar.f61759a), lVar, true, responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof BawuTeamReadCacheResponseMessage)) {
                return;
            }
            BawuTeamReadCacheResponseMessage bawuTeamReadCacheResponseMessage = (BawuTeamReadCacheResponseMessage) customResponsedMessage;
            e.this.f61759a = bawuTeamReadCacheResponseMessage.getBawuTeamInfo();
            e.this.f61760b = bawuTeamReadCacheResponseMessage.isPrivateForum() != 0;
            e.this.f61761c = bawuTeamReadCacheResponseMessage.getManagerApplyInfo();
            l lVar = new l();
            if (e.this.f61761c != null) {
                lVar.l(e.this.f61761c.manager_left_num.intValue());
                lVar.k(e.this.f61761c.manager_apply_url);
                lVar.h(e.this.f61761c.assist_left_num.intValue());
                lVar.g(e.this.f61761c.assist_apply_url);
            }
            if (e.this.f61762d != null) {
                c cVar = e.this.f61762d;
                e eVar = e.this;
                cVar.a(eVar.j(eVar.f61759a), lVar, false, customResponsedMessage.getError(), customResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(ArrayList<i> arrayList, l lVar, boolean z, int i2, String str);
    }

    public e() {
        MessageManager.getInstance().registerListener(this.f61764f);
        MessageManager.getInstance().registerListener(this.f61763e);
    }

    public void g() {
        MessageManager.getInstance().unRegisterListener(this.f61763e);
        MessageManager.getInstance().unRegisterListener(this.f61764f);
    }

    public void h(long j) {
        BawuTeamInfoReadCacheRequestMessage bawuTeamInfoReadCacheRequestMessage = new BawuTeamInfoReadCacheRequestMessage();
        bawuTeamInfoReadCacheRequestMessage.setCacheKey("" + j);
        MessageManager.getInstance().sendMessage(bawuTeamInfoReadCacheRequestMessage);
    }

    public void i(long j) {
        BawuTeamRequestMessage bawuTeamRequestMessage = new BawuTeamRequestMessage();
        bawuTeamRequestMessage.setForumId(j);
        MessageManager.getInstance().sendMessage(bawuTeamRequestMessage);
    }

    public ArrayList<i> j(BawuTeam bawuTeam) {
        List<BawuRoleDes> list;
        List<BawuRoleInfoPub> list2;
        ArrayList<i> arrayList = new ArrayList<>();
        if (bawuTeam == null || (list = bawuTeam.bawu_team_list) == null) {
            return null;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            BawuRoleDes bawuRoleDes = bawuTeam.bawu_team_list.get(i2);
            if (bawuRoleDes != null && !StringUtils.isNull(bawuRoleDes.role_name) && (list2 = bawuRoleDes.role_info) != null && list2.size() > 0) {
                d.a.o0.p0.a.c cVar = new d.a.o0.p0.a.c();
                cVar.c(bawuRoleDes.role_name + "(" + bawuRoleDes.role_info.size() + SmallTailInfo.EMOTION_SUFFIX);
                arrayList.add(cVar);
                int size2 = bawuRoleDes.role_info.size();
                int i3 = 0;
                while (i3 < size2) {
                    d.a.o0.p0.a.b bVar = new d.a.o0.p0.a.b();
                    bVar.i(bawuRoleDes.role_name);
                    ArrayList<BawuRoleInfoPub> arrayList2 = new ArrayList<>();
                    arrayList2.add(bawuRoleDes.role_info.get(i3));
                    int i4 = i3 + 1;
                    if (i4 < size2) {
                        arrayList2.add(bawuRoleDes.role_info.get(i4));
                    }
                    i3 += 2;
                    if (i3 >= size2) {
                        if (this.f61760b) {
                            bVar.f(false);
                        } else {
                            bVar.f(true);
                        }
                        bVar.g(true);
                    } else {
                        bVar.g(false);
                    }
                    bVar.h(arrayList2);
                    arrayList.add(bVar);
                }
                if (i2 <= size - 2) {
                    arrayList.add(new d.a.o0.p0.a.a());
                }
            }
        }
        return arrayList;
    }

    public void k(c cVar) {
        this.f61762d = cVar;
    }
}
