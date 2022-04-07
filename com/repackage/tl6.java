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
/* loaded from: classes7.dex */
public class tl6 implements p65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemInfo a;
    public List<AlbumElement> b;
    public ArrayList<uo> c;
    public boolean d;

    public tl6() {
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
            lm6 lm6Var = new lm6();
            lm6Var.i(dataRes.item_game_code);
            this.c.add(lm6Var);
        }
        ItemGameInfo itemGameInfo = dataRes.item_game_info;
        if (itemGameInfo != null) {
            List<ThreadInfo> list = itemGameInfo.hot_videos;
            if (list != null && ListUtils.getCount(list) >= 3) {
                mm6 mm6Var = new mm6();
                mm6Var.g(dataRes.item_game_info.hot_videos);
                this.c.add(mm6Var);
            }
            RecentUpdate recentUpdate = dataRes.item_game_info.recent_update;
            if (recentUpdate != null && !ni.isEmpty(recentUpdate.log)) {
                nm6 nm6Var = new nm6();
                nm6Var.g(dataRes.item_game_info.recent_update);
                this.c.add(nm6Var);
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            jm6 jm6Var = new jm6();
            jm6Var.setSupportType(BaseCardInfo.SupportType.TOP);
            this.c.add(jm6Var);
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.parser_title();
                    threadData.setPositionInFrsItemTab(i);
                    i++;
                    threadData.insertItemToTitleOrAbstractText();
                    this.c.add(threadData);
                    jm6 jm6Var2 = new jm6();
                    jm6Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    this.c.add(jm6Var2);
                }
            }
            jm6 jm6Var3 = new jm6();
            jm6Var3.g(this.a.id.intValue());
            jm6Var3.setPositionInFrsItemTab(i);
            jm6Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            this.c.add(jm6Var3);
        }
        km6 km6Var = new km6();
        km6Var.i(dataRes.item_info);
        if (km6Var.g()) {
            this.c.add(km6Var);
        }
        om6 om6Var = new om6();
        om6Var.g(dataRes.recommend_item);
        this.c.add(om6Var);
    }

    @Override // com.repackage.p65
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // com.repackage.p65
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }
}
