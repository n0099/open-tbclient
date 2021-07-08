package d.a.o0.r.r;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.d.l;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class a extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f52845a;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Integer> f52846b;

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<String> f52847c;

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<String, l<byte[]>> f52848d;

    /* renamed from: e  reason: collision with root package name */
    public static HashMap<String, l<String>> f52849e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(641991741, "Ld/a/o0/r/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(641991741, "Ld/a/o0/r/r/a;");
                return;
            }
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        f52846b = hashMap;
        hashMap.put("tb.pb_mark", 50);
        f52846b.put("tb.pb_history", 300);
        f52846b.put("tb.pb_normal", 1);
        f52846b.put("tb.pb_editor", 50);
        f52846b.put("tb.live_hotlist", 20);
        f52846b.put("tb.live_hotlist", 20);
        f52846b.put("tb.my_pages", 5);
        f52846b.put("tb.my_forums", 3);
        f52846b.put("tb.my_bookmarks", 3);
        f52846b.put("tb.my_posts", 3);
        f52846b.put("tb.eva_posts", 50);
        f52846b.put("tb.im_frsgroup", 50);
        f52846b.put("tb.im_hotgroup", 30);
        f52846b.put("tb.im_groupinfo", 50);
        f52846b.put("tb.im_groupactivity", 50);
        f52846b.put("tb.im_entergroup", 10);
        f52846b.put("tb.im_enterforum_groupinfo", 10);
        f52846b.put("tb.im_group_setting", 3);
        f52846b.put("tb.im_personal_chat_setting", 3);
        f52846b.put("tb.im_official_chat_setting", 3);
        f52846b.put("tb.im_group_search_history", 50);
        f52846b.put("tb.im_official_history", 50);
        f52846b.put("tb.im_recommend_detail", 10);
        f52846b.put("tb.square", 1);
        f52846b.put("tb.first_dir", 1);
        f52846b.put("tb.forum_rank", 20);
        f52846b.put("tb.pic_gif", 50);
        f52846b.put("tb.official_bar_menu", 1000);
        f52846b.put("tb.friend_feed", 20);
        f52846b.put("net_err_record", 30);
        f52846b.put("tb_face_package", 30);
        f52846b.put("tb.recommend_friend", 10);
        f52846b.put("tb.searchperson_history", 5);
        f52846b.put("tb.game_center_home", 20);
        f52846b.put("tb.game_center_list", 20);
        f52846b.put("tb.person_wallet_new", 10);
        f52846b.put("tb.frs_hottopic", 100);
        ArrayList<String> arrayList = new ArrayList<>();
        f52847c = arrayList;
        arrayList.add("tb.ala.gift_list");
        f52847c.add("tb.square");
        f52847c.add("tb.first_dir");
        f52847c.add("tb.forum_rank");
        f52847c.add("tb.im_group_setting");
        f52847c.add("tb.im_personal_chat_setting");
        f52847c.add("tb.im_official_chat_setting");
        f52847c.add("net_err_record");
        f52847c.add("tb_user_profile");
        f52847c.add("tb_forum_recommend");
        f52847c.add("tb.ad_killer_tags");
        f52847c.add("tb.manga.settings");
        f52847c.add("tb.share_add_experienced");
        f52847c.add("tb.write_privacy_state_space");
        f52847c.add("tb.concern_page_all");
        f52849e = new HashMap<>();
        f52848d = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super(2000998);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f52845a == null) {
                f52845a = new a();
            }
            return f52845a;
        }
        return (a) invokeV.objValue;
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || str == null) {
            return;
        }
        if (str2 != null) {
            str = str + str2;
        }
        l<byte[]> lVar = f52848d.get(str);
        if (lVar != null) {
            BdCacheService.l().k(lVar);
            f52848d.remove(str);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            c(str, null);
        }
    }

    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || str == null) {
            return;
        }
        if (str2 != null) {
            str = str + str2;
        }
        l<String> lVar = f52849e.get(str);
        if (lVar != null) {
            try {
                BdCacheService.l().k(lVar);
                f52849e.remove(str);
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public l<byte[]> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? e(str, null) : (l) invokeL.objValue;
    }

    public l<byte[]> e(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            if (str == null) {
                return null;
            }
            if (str2 != null) {
                str3 = str + str2;
            } else {
                str3 = str;
            }
            l<byte[]> lVar = f52848d.get(str3);
            if (lVar == null || !(lVar instanceof l)) {
                BdCacheService l = BdCacheService.l();
                Integer num = f52846b.get(str);
                num = (num == null || num.intValue() == 0) ? 20 : 20;
                BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
                if (f52847c.contains(str)) {
                    cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
                }
                try {
                    lVar = l.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                f52848d.put(str3, lVar);
                return lVar;
            }
            return lVar;
        }
        return (l) invokeLL.objValue;
    }

    public l<String> g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? h(str, null) : (l) invokeL.objValue;
    }

    public l<String> h(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            if (str == null) {
                return null;
            }
            if (str2 != null) {
                str3 = str + str2;
            } else {
                str3 = str;
            }
            l<String> lVar = f52849e.get(str3);
            BdCacheService l = BdCacheService.l();
            Integer num = f52846b.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (f52847c.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                return l.c(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return lVar;
            }
        }
        return (l) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, customResponsedMessage) == null) {
            f52848d.clear();
            f52849e.clear();
        }
    }
}
