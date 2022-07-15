package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.AlbumElement;
import tbclient.ItemGameCode;
import tbclient.ItemGameInfo;
import tbclient.ItemInfo;
import tbclient.ItemPage.DataRes;
import tbclient.RecentUpdate;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class cl6 implements u75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemInfo a;
    public List<AlbumElement> b;
    public ArrayList<nn> c;
    public boolean d;

    public cl6() {
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
        this.c = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
            return;
        }
        ItemInfo itemInfo = dataRes.item_info;
        this.a = itemInfo;
        if (itemInfo == null) {
            return;
        }
        this.b = dataRes.album_list;
        int i = 1;
        this.d = dataRes.has_tornado.intValue() == 1;
        ItemGameCode itemGameCode = dataRes.item_game_code;
        if (itemGameCode != null && ListUtils.getCount(itemGameCode.game_code_list) != 0) {
            ul6 ul6Var = new ul6();
            ul6Var.g(dataRes.item_game_code);
            this.c.add(ul6Var);
        }
        ItemGameInfo itemGameInfo = dataRes.item_game_info;
        if (itemGameInfo != null) {
            List<ThreadInfo> list = itemGameInfo.hot_videos;
            if (list != null && ListUtils.getCount(list) >= 3) {
                vl6 vl6Var = new vl6();
                vl6Var.d(dataRes.item_game_info.hot_videos);
                this.c.add(vl6Var);
            }
            RecentUpdate recentUpdate = dataRes.item_game_info.recent_update;
            if (recentUpdate != null && !oi.isEmpty(recentUpdate.log)) {
                wl6 wl6Var = new wl6();
                wl6Var.d(dataRes.item_game_info.recent_update);
                this.c.add(wl6Var);
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            sl6 sl6Var = new sl6();
            sl6Var.setSupportType(BaseCardInfo.SupportType.TOP);
            this.c.add(sl6Var);
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.parser_title();
                    threadData.setPositionInFrsItemTab(i);
                    i++;
                    threadData.insertItemToTitleOrAbstractText();
                    this.c.add(threadData);
                    sl6 sl6Var2 = new sl6();
                    sl6Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    this.c.add(sl6Var2);
                }
            }
            sl6 sl6Var3 = new sl6();
            sl6Var3.d(this.a.id.intValue());
            sl6Var3.setPositionInFrsItemTab(i);
            sl6Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            this.c.add(sl6Var3);
        }
        tl6 tl6Var = new tl6();
        tl6Var.g(dataRes.item_info);
        if (tl6Var.d()) {
            this.c.add(tl6Var);
        }
        xl6 xl6Var = new xl6();
        xl6Var.d(dataRes.recommend_item);
        this.c.add(xl6Var);
    }

    @Override // com.repackage.u75
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // com.repackage.u75
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }
}
