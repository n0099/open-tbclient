package com.repackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.LiveTabFeedView;
import com.baidu.live.business.base.LiveBaseFragment;
import com.baidu.live.business.listener.LiveFeedBannerListener;
import com.baidu.live.business.listener.LiveFeedFollowListener;
import com.baidu.live.business.listener.LiveFeedToolListener;
import com.baidu.live.business.listener.TabFeedActionListener;
import com.baidu.live.business.model.ILiveFeedModel;
import com.baidu.live.business.model.LiveFeedModel;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveBannerWrapData;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.live.business.model.data.LiveFeedData;
import com.baidu.live.business.model.data.LiveFeedToolWrapData;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.live.business.model.data.LiveFollowEntity;
import com.baidu.live.business.model.data.LiveFollowWrapData;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveTabWrapData;
import com.baidu.live.business.view.smarttab.SmartTabLayout;
import com.baidu.live.feedpage.interfaces.ILiveFeedOther;
import com.baidu.live.feedpage.interfaces.ILiveFeedRefresh;
import com.baidu.searchbox.launch.ExternalTransferSpeedStats;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.bumptech.glide.load.engine.GlideException;
import java.util.Map;
/* loaded from: classes5.dex */
public class b80 implements w90<c80> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final int b;
    public Context c;
    public FragmentManager d;
    public LiveTabFeedView e;
    public ILiveFeedModel f;
    public String g;
    public String h;
    public LiveFeedConfig i;
    public boolean j;
    public boolean k;
    public h l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public String q;
    public String r;
    public boolean s;
    public Flow t;
    public Flow u;
    public Flow v;
    public ILiveFeedRefresh.OnRefreshListener w;
    public ILiveFeedModel.OnDataLoadCallback x;
    public boolean y;
    public final BroadcastReceiver z;

    /* loaded from: classes5.dex */
    public class a implements ILiveFeedModel.OnDataLoadCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b80 a;

        public a(b80 b80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b80Var;
        }

        @Override // com.baidu.live.business.model.ILiveFeedModel.OnDataLoadCallback
        public void onFail(int i, String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i, str, map) == null) || map == null || TextUtils.isEmpty(map.get("resource")) || !TextUtils.equals(this.a.g, map.get("resource"))) {
                return;
            }
            LiveFeedData liveFeedData = new LiveFeedData();
            liveFeedData.getDataByCache(i, str, true, true);
            this.a.x(liveFeedData);
        }

        @Override // com.baidu.live.business.model.ILiveFeedModel.OnDataLoadCallback
        public void onSuccess(LiveFeedData liveFeedData, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFeedData, map) == null) {
                if (liveFeedData == null) {
                    onFail(-100, "数据解析失败", map);
                } else if ("follow".equals(liveFeedData.resource)) {
                    this.a.F(liveFeedData.followWrapData);
                } else {
                    this.a.x(liveFeedData);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TabFeedActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b80 a;

        public b(b80 b80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b80Var;
        }

        @Override // com.baidu.live.business.listener.TabFeedActionListener
        public void onClickErrorRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g0();
            }
        }

        @Override // com.baidu.live.business.listener.TabFeedActionListener
        public void onClickSearch() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.b0();
            }
        }

        @Override // com.baidu.live.business.listener.TabFeedActionListener
        public void onClickStartLive(View view2, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, textView) == null) {
                this.a.H(view2, textView);
            }
        }

        @Override // com.baidu.live.business.listener.TabFeedActionListener
        public void onSearchShowing(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.a.G(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements LiveFeedBannerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b80 a;

        public c(b80 b80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b80Var;
        }

        @Override // com.baidu.live.business.listener.LiveFeedBannerListener
        public void onBannerShow(@NonNull LiveBannerEntity liveBannerEntity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) {
                LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                g80.g(this.a.c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, liveHostInfo == null ? "" : liveHostInfo.uk, g80.n(this.a.h), liveBannerEntity.materialId, liveBannerEntity.statInfo);
            }
        }

        @Override // com.baidu.live.business.listener.LiveFeedBannerListener
        public void onClickBanner(@Nullable LiveBannerEntity liveBannerEntity) {
            LiveBannerEntity.BannerCmdInfo bannerCmdInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveBannerEntity) == null) {
                if (liveBannerEntity != null && (bannerCmdInfo = liveBannerEntity.cmdInfo) != null && !oa0.a(bannerCmdInfo.action)) {
                    LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                    g80.f(this.a.c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, liveHostInfo == null ? "" : liveHostInfo.uk, g80.n(this.a.h), liveBannerEntity.materialId, liveBannerEntity.statInfo);
                    LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, liveBannerEntity.cmdInfo.action);
                    return;
                }
                LiveFeedPageSdk.getInstance().getInvoker().showToast(this.a.c, this.a.c.getResources().getString(R.string.obfuscated_res_0x7f0f0a03));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements LiveFeedFollowListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b80 a;

        public d(b80 b80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b80Var;
        }

        @Override // com.baidu.live.business.listener.LiveFeedFollowListener
        public void onClickFollow(@NonNull LiveFollowEntity liveFollowEntity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, liveFollowEntity, i) == null) {
                String n = g80.n(this.a.h);
                if (liveFollowEntity.isMore) {
                    LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, liveFollowEntity.cmd);
                    g80.k(this.a.c, this.a.a, n);
                    return;
                }
                LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, liveFollowEntity.cmd);
                LiveHostInfo liveHostInfo = liveFollowEntity.hostInfo;
                g80.i(this.a.c, this.a.a, liveHostInfo == null ? "" : liveHostInfo.uk, n, i + 1, liveFollowEntity.roomId, liveFollowEntity.nid, liveFollowEntity.statInfo);
            }
        }

        @Override // com.baidu.live.business.listener.LiveFeedFollowListener
        public void onFollowShow(@NonNull LiveFollowEntity liveFollowEntity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFollowEntity, i) == null) {
                String n = g80.n(this.a.h);
                if (liveFollowEntity.isMore) {
                    g80.l(this.a.c, this.a.a, n);
                    return;
                }
                LiveHostInfo liveHostInfo = liveFollowEntity.hostInfo;
                g80.j(this.a.c, this.a.a, liveHostInfo == null ? "" : liveHostInfo.uk, n, i + 1, liveFollowEntity.roomId, liveFollowEntity.nid, liveFollowEntity.statInfo);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements LiveBaseFragment.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b80 a;

        public e(b80 b80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b80Var;
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onBannerItemClick(LiveBannerEntity liveBannerEntity) {
            LiveBannerEntity.BannerCmdInfo bannerCmdInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) {
                if (liveBannerEntity != null && (bannerCmdInfo = liveBannerEntity.cmdInfo) != null && !oa0.a(bannerCmdInfo.action)) {
                    LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                    g80.f(this.a.c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, liveHostInfo == null ? "" : liveHostInfo.uk, g80.n(this.a.h), liveBannerEntity.materialId, liveBannerEntity.statInfo);
                    LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, liveBannerEntity.cmdInfo.action);
                    return;
                }
                LiveFeedPageSdk.getInstance().getInvoker().showToast(this.a.c, this.a.c.getResources().getString(R.string.obfuscated_res_0x7f0f0a03));
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onBannerItemShow(LiveBannerEntity liveBannerEntity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveBannerEntity) == null) {
                LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                g80.g(this.a.c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, liveHostInfo == null ? "" : liveHostInfo.uk, g80.n(this.a.h), liveBannerEntity.materialId, liveBannerEntity.statInfo);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onClickFeedItemRoom(LiveRoomEntity liveRoomEntity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, liveRoomEntity, i) == null) {
                String a = p80.a(liveRoomEntity);
                LiveFeedPageSdk.liveLog("FeedItemClick: position: $position  scheme: $scheme");
                if (LiveFeedPageSdk.getInstance().getInvoker() != null) {
                    LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, a);
                }
                g80.q(this.a.h, this.a.a, Boolean.FALSE, liveRoomEntity, this.a.c, i);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onFeedItemRoomShow(LiveRoomEntity liveRoomEntity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, liveRoomEntity, i) == null) {
                g80.q(this.a.h, this.a.a, Boolean.TRUE, liveRoomEntity, this.a.c, i);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onFeedReserveHeaderItemClick(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                g80.x(this.a.c, this.a.h, this.a.a, Boolean.FALSE, str);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onFeedStabilityLog(LiveFeedWrapData liveFeedWrapData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, liveFeedWrapData, i) == null) {
                g80.h(this.a.c, this.a.a, g80.n(this.a.h), liveFeedWrapData.errCode, liveFeedWrapData.errMsg, liveFeedWrapData.tab, liveFeedWrapData.subTab, liveFeedWrapData.sessionId, la0.c(liveFeedWrapData.roomInfoList) ? 0 : liveFeedWrapData.roomInfoList.size(), i, liveFeedWrapData.refreshType, liveFeedWrapData.refreshIndex);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onHitCache(String str, String str2, String str3, String str4, String str5, int i, LiveFeedWrapData liveFeedWrapData, LiveFeedWrapData liveFeedWrapData2) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, str4, str5, Integer.valueOf(i), liveFeedWrapData, liveFeedWrapData2}) == null) && liveFeedWrapData.isCacheData) {
                if (i == -101) {
                    i2 = 1;
                } else {
                    i2 = (liveFeedWrapData2 == null || liveFeedWrapData2.errCode == 0) ? 2 : 3;
                }
                g80.r(this.a.c, this.a.a, g80.n(this.a.h), liveFeedWrapData2 == null ? -100 : liveFeedWrapData2.errCode, liveFeedWrapData2 == null ? "" : liveFeedWrapData2.errMsg, str4, str5, str, str2, str3, i2, ExternalTransferSpeedStats.FEED_PAGE, liveFeedWrapData.cacheTime, System.currentTimeMillis(), 1);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onItemLabelClickListener(String str, int i, LiveRoomEntity liveRoomEntity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048583, this, str, i, liveRoomEntity) == null) {
                g80.B(this.a.c, this.a.a, g80.n(this.a.h), i, liveRoomEntity);
                if (LiveFeedPageSdk.getInstance().getInvoker() != null) {
                    LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.a.c, str);
                }
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onItemPlayerEnd(int i, String str, String str2, int i2, LiveRoomEntity liveRoomEntity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), liveRoomEntity}) == null) {
                if (i == 1) {
                    if (this.a.u == null || liveRoomEntity == null) {
                        return;
                    }
                    g80.v(this.a.c, false, this.a.a, g80.n(this.a.h), i2, str, str2, liveRoomEntity, this.a.u);
                    this.a.u = null;
                } else if (i != 2 || this.a.v == null || liveRoomEntity == null) {
                } else {
                    g80.v(this.a.c, false, this.a.a, g80.n(this.a.h), i2, str, str2, liveRoomEntity, this.a.v);
                    this.a.v = null;
                }
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onItemPlayerStart(int i, String str, String str2, int i2, LiveRoomEntity liveRoomEntity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), liveRoomEntity}) == null) {
                if (i == 1) {
                    b80 b80Var = this.a;
                    b80Var.u = g80.v(b80Var.c, true, this.a.a, g80.n(this.a.h), i2, str, str2, liveRoomEntity, null);
                } else if (i == 2) {
                    b80 b80Var2 = this.a;
                    b80Var2.v = g80.v(b80Var2.c, true, this.a.a, g80.n(this.a.h), i2, str, str2, liveRoomEntity, null);
                }
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onShowToast(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || LiveFeedPageSdk.getInstance().getInvoker() == null) {
                return;
            }
            LiveFeedPageSdk.getInstance().getInvoker().showToast(this.a.c, str);
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onSlideLoadMore(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
                g80.C(this.a.c, this.a.a, g80.n(this.a.h), str, str2);
            }
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onTabPageHideLog(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) || this.a.t == null) {
                return;
            }
            LiveFeedPageSdk.liveLog("LivePageLog onHintLog  " + str + GlideException.IndentedAppendable.INDENT + str2 + "   " + this.a.t.hashCode());
            g80.s(this.a.c, false, this.a.a, g80.n(this.a.h), str, str2, this.a.t);
            this.a.t = null;
        }

        @Override // com.baidu.live.business.base.LiveBaseFragment.a
        public void onTabPageShowLog(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
                b80 b80Var = this.a;
                b80Var.t = g80.s(b80Var.c, true, this.a.a, g80.n(this.a.h), str, str2, null);
                LiveFeedPageSdk.liveLog("LivePageLog onShowLog  " + str + GlideException.IndentedAppendable.INDENT + str2 + "   " + this.a.t.hashCode());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements LiveFeedToolListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b80 a;

        public f(b80 b80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b80Var;
        }

        @Override // com.baidu.live.business.listener.LiveFeedToolListener
        public void onItemClick(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                g80.A(this.a.c, this.a.h, this.a.a, Boolean.FALSE, str);
            }
        }

        @Override // com.baidu.live.business.listener.LiveFeedToolListener
        public void onItemShow(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                g80.A(this.a.c, this.a.h, this.a.a, Boolean.TRUE, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b80 this$0;

        public g(b80 b80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = b80Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.Q();
                boolean f = m80.f(context);
                if (!f || this.this$0.o) {
                    this.this$0.o = f;
                    return;
                }
                this.this$0.o = true;
                if (this.this$0.m) {
                    LiveFeedPageSdk.liveLog("网络变化: Tab 可用，Feed 刷新");
                    this.this$0.U();
                    return;
                }
                LiveFeedPageSdk.liveLog("网络变化: 全页面刷新");
                this.this$0.P();
            }
        }
    }

    public b80(Context context, int i, FragmentManager fragmentManager, String str, String str2, boolean z, String str3, String str4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), fragmentManager, str, str2, Boolean.valueOf(z), str3, str4, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = true;
        this.l = new h(null);
        this.x = new a(this);
        this.y = false;
        this.z = new g(this);
        this.c = context;
        this.a = str2;
        this.d = fragmentManager;
        this.h = str;
        this.q = str3;
        this.r = str4;
        this.s = z2;
        this.p = z;
        this.l.b = System.currentTimeMillis();
        LiveFeedPageSdk.IMMERSION.equals(this.h);
        this.b = i;
        z90.a().d(this, d80.class, this);
        z90.a().d(this, f80.class, this);
        z90.a().d(this, e80.class, this);
        N();
        LiveFeedModel liveFeedModel = new LiveFeedModel(this.h, this.a);
        this.f = liveFeedModel;
        this.e.setFeedModel(liveFeedModel);
        this.g = this.f.getInitResource();
        this.e.E(this.h, this.p, this.b, this.d, this.q, this.r);
    }

    public RecyclerView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.getMSubTipLayout();
            }
            return null;
        }
        return (RecyclerView) invokeV.objValue;
    }

    public SmartTabLayout B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.getMSmartTabLayout();
            }
            return null;
        }
        return (SmartTabLayout) invokeV.objValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.getMViewPager();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void D(LiveFeedConfig liveFeedConfig) {
        LiveFeedConfig.AbSwitchConfig abSwitchConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, liveFeedConfig) == null) {
            this.i = liveFeedConfig;
            boolean z = (liveFeedConfig == null || (abSwitchConfig = liveFeedConfig.abSwitchConfig) == null || !abSwitchConfig.newTab) ? false : true;
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.setTabStyle(z);
            }
            if (liveFeedConfig != null) {
                this.l.b(liveFeedConfig.timeoutRefreshTime * 1000);
            }
        }
    }

    public final void E(LiveFeedData liveFeedData) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, liveFeedData) == null) || liveFeedData == null) {
            return;
        }
        D(liveFeedData.feedConfig);
        e0(liveFeedData.bannerWrapData);
        J(liveFeedData);
        I(r80.a());
        F(liveFeedData.followWrapData);
        K(liveFeedData.toolWrapData, liveFeedData.feedConfig);
        if (!this.s || (liveTabFeedView = this.e) == null) {
            return;
        }
        this.s = false;
        liveTabFeedView.setExpanded(false);
    }

    public final void F(LiveFollowWrapData liveFollowWrapData) {
        LiveFeedConfig.AbSwitchConfig abSwitchConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, liveFollowWrapData) == null) || this.e == null) {
            return;
        }
        LiveFeedConfig liveFeedConfig = this.i;
        this.e.y(liveFollowWrapData, (liveFeedConfig == null || (abSwitchConfig = liveFeedConfig.abSwitchConfig) == null || !abSwitchConfig.otherNewStyle) ? false : true);
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                h0();
                g80.H(this.c);
                return;
            }
            M(false);
        }
    }

    public final void H(View view2, TextView textView) {
        String defaultStartLiveScheme;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, textView) == null) {
            LiveFeedConfig liveFeedConfig = this.i;
            if (liveFeedConfig != null && !TextUtils.isEmpty(liveFeedConfig.startLiveScheme)) {
                defaultStartLiveScheme = this.i.startLiveScheme;
            } else {
                defaultStartLiveScheme = LiveFeedPageSdk.getInstance().getDefaultStartLiveScheme();
            }
            if (LiveFeedPageSdk.getInstance().getHKInvoker() != null) {
                LiveFeedPageSdk.getInstance().getHKInvoker().clickStartLive(view2, textView, defaultStartLiveScheme);
            } else if (LiveFeedPageSdk.getInstance().getInvoker() != null) {
                LiveFeedPageSdk.getInstance().getInvoker().invokeScheme(this.c, defaultStartLiveScheme);
            }
        }
    }

    public final void I(int i) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (liveTabFeedView = this.e) == null) {
            return;
        }
        liveTabFeedView.z(i);
    }

    public final void J(LiveFeedData liveFeedData) {
        LiveTabWrapData liveTabWrapData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, liveFeedData) == null) || liveFeedData == null) {
            return;
        }
        r80.b();
        if (this.y || (liveTabWrapData = liveFeedData.tabWrapData) == null || la0.c(liveTabWrapData.tabList)) {
            return;
        }
        this.y = true;
        LiveTabFeedView liveTabFeedView = this.e;
        if (liveTabFeedView != null) {
            liveTabFeedView.A(liveFeedData);
        }
        if (liveFeedData.tabWrapData.isCacheData) {
            Context context = this.c;
            String str = this.a;
            String n = g80.n(this.h);
            LiveTabWrapData liveTabWrapData2 = liveFeedData.tabWrapData;
            g80.r(context, str, n, liveTabWrapData2.errCode, liveTabWrapData2.errMsg, liveFeedData.logId, liveFeedData.resource, "", "", "", liveTabWrapData2.cacheCause, "tab", liveTabWrapData2.cacheTime, System.currentTimeMillis(), 1);
        }
    }

    public final void K(LiveFeedToolWrapData liveFeedToolWrapData, LiveFeedConfig liveFeedConfig) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, liveFeedToolWrapData, liveFeedConfig) == null) || (liveTabFeedView = this.e) == null) {
            return;
        }
        liveTabFeedView.B(liveFeedToolWrapData, liveFeedConfig);
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.C();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.h0(false);
            }
            if (z) {
                o80.d("sp_search_guide_show", true);
            }
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            LiveTabFeedView liveTabFeedView = new LiveTabFeedView(this.c);
            this.e = liveTabFeedView;
            liveTabFeedView.setFeedActionListener(new b(this));
            this.e.setFeedBannerListener(new c(this));
            this.e.setFeedFollowListener(new d(this));
            this.e.setSubTabPageListener(new e(this));
            this.e.setFeedToolListener(new f(this));
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.J();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.i0();
            }
            g0();
        }
    }

    public final void Q() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (liveTabFeedView = this.e) == null) {
            return;
        }
        liveTabFeedView.K();
    }

    public void R(String str) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || (liveTabFeedView = this.e) == null) {
            return;
        }
        liveTabFeedView.N(str);
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            z90.a().e(this);
            i0();
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.O();
            }
            this.k = true;
            r80.b();
            this.p = false;
            n90.d(String.valueOf(this.b));
        }
    }

    public void T(ILiveFeedRefresh.OnLoadMoreListener onLoadMoreListener) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, onLoadMoreListener) == null) || (liveTabFeedView = this.e) == null) {
            return;
        }
        liveTabFeedView.P(onLoadMoreListener);
    }

    public void U() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (liveTabFeedView = this.e) == null) {
            return;
        }
        liveTabFeedView.Q(null);
    }

    public void V(ILiveFeedRefresh.OnRefreshListener onRefreshListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onRefreshListener) == null) {
            if (this.y) {
                LiveTabFeedView liveTabFeedView = this.e;
                if (liveTabFeedView != null) {
                    liveTabFeedView.Q(onRefreshListener);
                    return;
                }
                return;
            }
            this.w = onRefreshListener;
            g0();
        }
    }

    public void W(int i) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i) == null) || (liveTabFeedView = this.e) == null) {
            return;
        }
        liveTabFeedView.R(i);
    }

    public final void X() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (liveTabFeedView = this.e) == null) {
            return;
        }
        liveTabFeedView.S();
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.T();
            }
            if (this.l.a()) {
                LiveTabFeedView liveTabFeedView2 = this.e;
                if (liveTabFeedView2 != null) {
                    liveTabFeedView2.Q(null);
                }
            } else {
                ILiveFeedModel iLiveFeedModel = this.f;
                if (iLiveFeedModel != null && !this.k) {
                    iLiveFeedModel.reqFollow(this.x);
                }
            }
            this.k = false;
        }
    }

    public void Z() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (liveTabFeedView = this.e) == null) {
            return;
        }
        liveTabFeedView.U();
    }

    public void a0() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (liveTabFeedView = this.e) == null) {
            return;
        }
        liveTabFeedView.V();
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            M(true);
            g80.G(this.c);
            LiveFeedPageSdk.getInstance().startLiveSearchActivity(this.c);
        }
    }

    public void c0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, str2) == null) {
            LiveFeedPageSdk.liveLog("D8800088 onTabSelectedEvent 新值 subTabType = " + str + ", thirdTabType = " + str2);
            LiveFeedPageSdk.liveLog("D8800088 onTabSelectedEvent 旧值 mSubTabType = " + this.q + ", mThirdTabType = " + this.r);
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                liveTabFeedView.W(str, str2);
            }
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            LiveFeedPageSdk.liveLog("onUserVisibleHint " + this.k + " " + z);
            if (this.j == z) {
                return;
            }
            this.j = z;
            if (z) {
                Y();
                f0();
                return;
            }
            X();
            i0();
        }
    }

    public final void e0(LiveBannerWrapData liveBannerWrapData) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, liveBannerWrapData) == null) || (liveTabFeedView = this.e) == null) {
            return;
        }
        liveTabFeedView.Y(liveBannerWrapData);
    }

    public final void f0() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (context = this.c) == null || this.n) {
            return;
        }
        this.o = m80.f(context);
        LiveFeedPageSdk.liveLog("注册网络变化广播");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.c.registerReceiver(this.z, intentFilter);
        this.n = true;
    }

    public final void g0() {
        ILiveFeedModel iLiveFeedModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (iLiveFeedModel = this.f) == null) {
            return;
        }
        iLiveFeedModel.reqInit(this.x);
    }

    public final void h0() {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || o80.a("sp_search_guide_show", false) || (liveTabFeedView = this.e) == null) {
            return;
        }
        liveTabFeedView.h0(true);
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.c != null && this.n) {
            LiveFeedPageSdk.liveLog("解注册网络变化广播");
            this.c.unregisterReceiver(this.z);
            this.n = false;
        }
    }

    public void u(ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener) {
        LiveTabFeedView liveTabFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, liveFeedStatusListener) == null) || (liveTabFeedView = this.e) == null) {
            return;
        }
        liveTabFeedView.q(liveFeedStatusListener);
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.u();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.v();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void x(LiveFeedData liveFeedData) {
        LiveTabWrapData liveTabWrapData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, liveFeedData) == null) {
            ILiveFeedRefresh.OnRefreshListener onRefreshListener = this.w;
            if (onRefreshListener != null) {
                onRefreshListener.onPullRefreshEnd();
            }
            if (liveFeedData != null && (liveTabWrapData = liveFeedData.tabWrapData) != null && !la0.c(liveTabWrapData.tabList)) {
                E(liveFeedData);
                LiveTabFeedView liveTabFeedView = this.e;
                if (liveTabFeedView != null) {
                    liveTabFeedView.e0();
                }
                this.m = true;
                if (liveFeedData.tabWrapData.isCacheData) {
                    return;
                }
                this.l.c();
                return;
            }
            LiveTabFeedView liveTabFeedView2 = this.e;
            if (liveTabFeedView2 != null) {
                liveTabFeedView2.f0();
            }
            this.m = false;
        }
    }

    public RecyclerView y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            LiveTabFeedView liveTabFeedView = this.e;
            if (liveTabFeedView != null) {
                return liveTabFeedView.getMConcernListRecyclerView();
            }
            return null;
        }
        return (RecyclerView) invokeV.objValue;
    }

    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public long b;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = LiveFeedPageSdk.REFRESH_TIME;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LiveFeedPageSdk.liveLog("onShow   " + (System.currentTimeMillis() - this.b));
                return System.currentTimeMillis() - this.b > this.a;
            }
            return invokeV.booleanValue;
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || j <= 0) {
                return;
            }
            this.a = j;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b = System.currentTimeMillis();
            }
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w90
    public void call(c80 c80Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, c80Var) == null) && c80Var != null && c80Var.a() == this.b) {
            LiveFeedPageSdk.liveLog("LiveEventBus event: " + c80Var.getClass() + GlideException.IndentedAppendable.INDENT + c80Var.a());
            if (c80Var instanceof d80) {
                LiveBannerWrapData liveBannerWrapData = ((d80) c80Var).b;
                if (liveBannerWrapData != null) {
                    e0(liveBannerWrapData);
                }
            } else if (c80Var instanceof f80) {
                LiveFollowWrapData liveFollowWrapData = ((f80) c80Var).b;
                if (liveFollowWrapData != null) {
                    F(liveFollowWrapData);
                }
            } else if (c80Var instanceof e80) {
                this.l.c();
            }
        }
    }
}
