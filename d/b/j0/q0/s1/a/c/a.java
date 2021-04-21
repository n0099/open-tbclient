package d.b.j0.q0.s1.a.c;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Wire;
import d.b.c.e.d.l;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
import d.b.i0.z0.n;
import d.b.j0.q0.s1.a.d.e;
import java.io.IOException;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumGuideTabResIdl;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public l<byte[]> f60619a;

    /* renamed from: b  reason: collision with root package name */
    public c f60620b;

    /* renamed from: d.b.j0.q0.s1.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1524a extends f0<GameForumGuideTabResIdl> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f60621a;

        public C1524a(String str) {
            this.f60621a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.f0
        /* renamed from: a */
        public GameForumGuideTabResIdl doInBackground() {
            Wire wire = new Wire(new Class[0]);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            l lVar = a.this.f60619a;
            byte[] bArr = (byte[]) lVar.get(currentAccount + this.f60621a);
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                return (GameForumGuideTabResIdl) wire.parseFrom(bArr, GameForumGuideTabResIdl.class);
            } catch (IOException e2) {
                BdLog.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements n<GameForumGuideTabResIdl> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(GameForumGuideTabResIdl gameForumGuideTabResIdl) {
            if (gameForumGuideTabResIdl == null) {
                return;
            }
            List<e> a2 = d.b.j0.q0.s1.a.b.a.a(gameForumGuideTabResIdl.data.sub_tab_list);
            List<d.b.c.j.e.n> b2 = d.b.j0.q0.s1.a.b.a.b(gameForumGuideTabResIdl.data.thread_list);
            boolean z = gameForumGuideTabResIdl.data.has_more.intValue() == 1;
            if (a.this.f60620b != null) {
                a.this.f60620b.a(a2, b2, z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(List<e> list, List<d.b.c.j.e.n> list2, boolean z);
    }

    public a() {
        this.f60619a = null;
        this.f60619a = BdCacheService.l().a("tb.frs.game.strategy.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public void c(String str) {
        if (this.f60619a == null || str == null) {
            return;
        }
        h0.b(new C1524a(str), new b());
    }

    public void d(String str, byte[] bArr, boolean z) {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (z) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            l<byte[]> lVar = this.f60619a;
            lVar.e(currentAccount + str, bArr, 604800000L);
            return;
        }
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        l<byte[]> lVar2 = this.f60619a;
        lVar2.i(currentAccount2 + str, bArr, 604800000L);
    }

    public void e(c cVar) {
        this.f60620b = cVar;
    }
}
