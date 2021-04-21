package d.b.i0.r.r;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.e.d.l;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends CustomMessageListener {

    /* renamed from: a  reason: collision with root package name */
    public static a f51701a;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Integer> f51702b;

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<String> f51703c;

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<String, l<byte[]>> f51704d;

    /* renamed from: e  reason: collision with root package name */
    public static HashMap<String, l<String>> f51705e;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f51702b = hashMap;
        hashMap.put("tb.pb_mark", 50);
        f51702b.put("tb.pb_history", 300);
        f51702b.put("tb.pb_normal", 1);
        f51702b.put("tb.pb_editor", 50);
        f51702b.put("tb.live_hotlist", 20);
        f51702b.put("tb.live_hotlist", 20);
        f51702b.put("tb.my_pages", 5);
        f51702b.put("tb.my_forums", 3);
        f51702b.put("tb.my_bookmarks", 3);
        f51702b.put("tb.my_posts", 3);
        f51702b.put("tb.eva_posts", 50);
        f51702b.put("tb.im_frsgroup", 50);
        f51702b.put("tb.im_hotgroup", 30);
        f51702b.put("tb.im_groupinfo", 50);
        f51702b.put("tb.im_groupactivity", 50);
        f51702b.put("tb.im_entergroup", 10);
        f51702b.put("tb.im_enterforum_groupinfo", 10);
        f51702b.put("tb.im_group_setting", 3);
        f51702b.put("tb.im_personal_chat_setting", 3);
        f51702b.put("tb.im_official_chat_setting", 3);
        f51702b.put("tb.im_group_search_history", 50);
        f51702b.put("tb.im_official_history", 50);
        f51702b.put("tb.im_recommend_detail", 10);
        f51702b.put("tb.square", 1);
        f51702b.put("tb.first_dir", 1);
        f51702b.put("tb.forum_rank", 20);
        f51702b.put("tb.pic_gif", 50);
        f51702b.put("tb.official_bar_menu", 1000);
        f51702b.put("tb.friend_feed", 20);
        f51702b.put("net_err_record", 30);
        f51702b.put("tb_face_package", 30);
        f51702b.put("tb.recommend_friend", 10);
        f51702b.put("tb.searchperson_history", 5);
        f51702b.put("tb.game_center_home", 20);
        f51702b.put("tb.game_center_list", 20);
        f51702b.put("tb.person_wallet_new", 10);
        f51702b.put("tb.frs_hottopic", 100);
        ArrayList<String> arrayList = new ArrayList<>();
        f51703c = arrayList;
        arrayList.add("tb.ala.gift_list");
        f51703c.add("tb.square");
        f51703c.add("tb.first_dir");
        f51703c.add("tb.forum_rank");
        f51703c.add("tb.im_group_setting");
        f51703c.add("tb.im_personal_chat_setting");
        f51703c.add("tb.im_official_chat_setting");
        f51703c.add("net_err_record");
        f51703c.add("tb_user_profile");
        f51703c.add("tb_forum_recommend");
        f51703c.add("tb.ad_killer_tags");
        f51703c.add("tb.manga.settings");
        f51703c.add("tb.share_add_experienced");
        f51703c.add("tb.write_privacy_state_space");
        f51703c.add("tb.concern_page_all");
        f51705e = new HashMap<>();
        f51704d = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public static a f() {
        if (f51701a == null) {
            f51701a = new a();
        }
        return f51701a;
    }

    public void a(String str, String str2) {
        if (str == null) {
            return;
        }
        if (str2 != null) {
            str = str + str2;
        }
        l<byte[]> lVar = f51704d.get(str);
        if (lVar != null) {
            BdCacheService.l().k(lVar);
            f51704d.remove(str);
        }
    }

    public void b(String str) {
        c(str, null);
    }

    public void c(String str, String str2) {
        if (str == null) {
            return;
        }
        if (str2 != null) {
            str = str + str2;
        }
        l<String> lVar = f51705e.get(str);
        if (lVar != null) {
            try {
                BdCacheService.l().k(lVar);
                f51705e.remove(str);
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public l<byte[]> d(String str) {
        return e(str, null);
    }

    public l<byte[]> e(String str, String str2) {
        String str3;
        if (str == null) {
            return null;
        }
        if (str2 != null) {
            str3 = str + str2;
        } else {
            str3 = str;
        }
        l<byte[]> lVar = f51704d.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService l = BdCacheService.l();
            Integer num = f51702b.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (f51703c.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = l.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
            f51704d.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> g(String str) {
        return h(str, null);
    }

    public l<String> h(String str, String str2) {
        String str3;
        if (str == null) {
            return null;
        }
        if (str2 != null) {
            str3 = str + str2;
        } else {
            str3 = str;
        }
        l<String> lVar = f51705e.get(str3);
        BdCacheService l = BdCacheService.l();
        Integer num = f51702b.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (f51703c.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return l.c(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e2) {
            BdLog.detailException(e2);
            return lVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        f51704d.clear();
        f51705e.clear();
    }
}
