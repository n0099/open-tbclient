package d.a.n0.e3;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static final Wire f57643c = new Wire(new Class[0]);

    /* renamed from: d  reason: collision with root package name */
    public static e f57644d;

    /* renamed from: a  reason: collision with root package name */
    public m f57645a = null;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.e.d.l<byte[]> f57646b;

    public e() {
        this.f57646b = null;
        this.f57646b = BdCacheService.l().a("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static e i() {
        if (f57644d == null) {
            synchronized (e.class) {
                if (f57644d == null) {
                    f57644d = new e();
                }
            }
        }
        return f57644d;
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (z) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            d.a.c.e.d.l<byte[]> lVar = this.f57646b;
            lVar.e(currentAccount + str, bArr, h());
            return;
        }
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        d.a.c.e.d.l<byte[]> lVar2 = this.f57646b;
        lVar2.i(currentAccount2 + str, bArr, h());
    }

    public void b(String str, String str2) {
        if (this.f57646b == null || str == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.c.e.d.l<byte[]> lVar = this.f57646b;
        byte[] bArr = lVar.get(currentAccount + str);
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) f57643c.parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl == null || frsPageResIdl.data == null || frsPageResIdl.data.forum == null || frsPageResIdl.data.forum.banner_list == null || frsPageResIdl.data.forum.banner_list.app == null || frsPageResIdl.data.forum.banner_list.app.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (App app : frsPageResIdl.data.forum.banner_list.app) {
                if (app != null && str2.equals(d.a.n0.t2.c.a(app))) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(frsPageResIdl.data.forum.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            FrsPageResIdl.Builder builder2 = new FrsPageResIdl.Builder(frsPageResIdl);
            DataRes.Builder builder3 = new DataRes.Builder(frsPageResIdl.data);
            ForumInfo.Builder builder4 = new ForumInfo.Builder(frsPageResIdl.data.forum);
            builder4.banner_list = builder.build(true);
            builder3.forum = builder4.build(true);
            builder2.data = builder3.build(true);
            a(str, builder2.build(true).toByteArray(), true);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void c(String str, String str2) {
        if (this.f57646b == null || str == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.c.e.d.l<byte[]> lVar = this.f57646b;
        byte[] bArr = lVar.get(currentAccount + str);
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) f57643c.parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl == null || frsPageResIdl.data == null || frsPageResIdl.data.ala_stage_list == null) {
                return;
            }
            DataRes.Builder builder = new DataRes.Builder(frsPageResIdl.data);
            if (builder.ala_stage_list != null) {
                builder.ala_stage_list.clear();
            }
            FrsPageResIdl.Builder builder2 = new FrsPageResIdl.Builder(frsPageResIdl);
            builder2.data = builder.build(true);
            a(str, builder2.build(true).toByteArray(), true);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void d(String str, String str2) {
        if (this.f57646b == null || str == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.c.e.d.l<byte[]> lVar = this.f57646b;
        byte[] bArr = lVar.get(currentAccount + str);
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) f57643c.parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl == null || frsPageResIdl.data == null || frsPageResIdl.data.thread_list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : frsPageResIdl.data.thread_list) {
                if (threadInfo != null && threadInfo.tid != null && str2 != null && str2.equals(threadInfo.tid.toString())) {
                    arrayList.add(threadInfo);
                }
            }
            DataRes.Builder builder = new DataRes.Builder(frsPageResIdl.data);
            if (builder.thread_list != null) {
                builder.thread_list.removeAll(arrayList);
            }
            FrsPageResIdl.Builder builder2 = new FrsPageResIdl.Builder(frsPageResIdl);
            builder2.data = builder.build(true);
            a(str, builder2.build(true).toByteArray(), true);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public boolean e(String str) {
        if (this.f57646b != null && str != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            d.a.c.e.d.l<byte[]> lVar = this.f57646b;
            byte[] bArr = lVar.get(currentAccount + str);
            if (bArr != null && bArr.length > 0) {
                m mVar = new m();
                this.f57645a = mVar;
                mVar.parserProtobuf(bArr, false);
                ForumData forumData = this.f57645a.forum;
                if (forumData == null || forumData.getFrsBannerData() == null) {
                    return true;
                }
                this.f57645a.forum.getFrsBannerData().f53695i = false;
                return true;
            }
        }
        return false;
    }

    public final User f(List<User> list, long j) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        for (User user : list) {
            if (user != null && user.id.longValue() == j) {
                return user;
            }
        }
        return null;
    }

    public String g(String str, int i2, int i3, int i4) {
        String str2 = str + i2 + i3;
        if (i4 != 0) {
            return str + i2 + i3 + FrsRequestData.CATEGORY_ID_KEY + i4;
        }
        return str2;
    }

    public long h() {
        long l = d.a.m0.r.d0.b.j().l("key_frs_cache_time", 604800000L);
        if (l < 0) {
            return 604800000L;
        }
        return l;
    }

    public m j() {
        return this.f57645a;
    }

    public final boolean k(long j, List<ThreadInfo> list) {
        Long l;
        int count = ListUtils.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            ThreadInfo threadInfo = (ThreadInfo) ListUtils.getItem(list, i2);
            if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == j) {
                return true;
            }
        }
        return false;
    }

    public boolean l(String str) {
        l.b<byte[]> h2;
        if (str == null || str.length() <= 0 || (h2 = this.f57646b.h(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(h2.f42196c, System.currentTimeMillis());
    }

    public void m(String str, byte[] bArr) {
        List<ThreadInfo> list;
        int count;
        if (this.f57646b == null || str == null || bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) f57643c.parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl == null || frsPageResIdl.data == null || (count = ListUtils.getCount((list = frsPageResIdl.data.thread_list))) <= 0) {
                return;
            }
            if (count >= 15) {
                a(str, bArr, true);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            d.a.c.e.d.l<byte[]> lVar = this.f57646b;
            byte[] bArr2 = lVar.get(currentAccount + str);
            if (bArr2 != null) {
                FrsPageResIdl frsPageResIdl2 = (FrsPageResIdl) f57643c.parseFrom(bArr2, FrsPageResIdl.class);
                if (frsPageResIdl2 != null && frsPageResIdl2.data != null && frsPageResIdl2.data.thread_list != null) {
                    List<ThreadInfo> list2 = frsPageResIdl2.data.thread_list;
                    int count2 = ListUtils.getCount(list2);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i2 = 0;
                    for (int i3 = 15; i2 < count2 && count < i3; i3 = 15) {
                        ThreadInfo threadInfo = (ThreadInfo) ListUtils.getItem(list2, i2);
                        if (threadInfo != null && threadInfo.tid != null && threadInfo.is_top.intValue() == 0 && !k(threadInfo.tid.longValue(), list)) {
                            arrayList.add(threadInfo);
                            User f2 = f(frsPageResIdl2.data.user_list, threadInfo.author_id.longValue());
                            if (f2 != null) {
                                arrayList2.add(f2);
                            }
                            count++;
                        }
                        i2++;
                    }
                    FrsPageResIdl.Builder builder = new FrsPageResIdl.Builder(frsPageResIdl);
                    DataRes.Builder builder2 = new DataRes.Builder(frsPageResIdl.data);
                    builder2.thread_list.addAll(arrayList);
                    builder2.user_list.addAll(arrayList2);
                    builder.data = builder2.build(true);
                    a(str, builder.build(true).toByteArray(), true);
                    return;
                }
                a(str, bArr, true);
                return;
            }
            a(str, bArr, true);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void n(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (z) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            d.a.c.e.d.l<byte[]> lVar = this.f57646b;
            lVar.remove(currentAccount + str);
            return;
        }
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        d.a.c.e.d.l<byte[]> lVar2 = this.f57646b;
        lVar2.d(currentAccount2 + str);
    }
}
