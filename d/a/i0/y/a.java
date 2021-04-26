package d.a.i0.y;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.game.GameShareJsBridge;
import com.baidu.tbadk.game.RequestGameDetailMessage;
import com.baidu.tbadk.game.ResponseGameDetailMessage;
import com.baidu.tieba.R;
import d.a.c.c.g.c;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static a f50071d = new a();

    /* renamed from: a  reason: collision with root package name */
    public GameInfoData f50072a;

    /* renamed from: b  reason: collision with root package name */
    public String f50073b;

    /* renamed from: c  reason: collision with root package name */
    public final c f50074c = new b(303009);

    /* renamed from: d.a.i0.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1088a implements CustomMessageTask.CustomRunnable<String> {
        public C1088a() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            if (customMessage == null) {
                return null;
            }
            return new CustomResponsedMessage<>(2001261, a.this.e());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseGameDetailMessage) || socketResponsedMessage.hasError()) {
                return;
            }
            ResponseGameDetailMessage responseGameDetailMessage = (ResponseGameDetailMessage) socketResponsedMessage;
            if (responseGameDetailMessage.getOrginalMessage() instanceof RequestGameDetailMessage) {
                a.this.f50072a = GameInfoData.fromGameInfo(responseGameDetailMessage.getGameInfo());
            }
        }
    }

    public a() {
        MessageManager.getInstance().registerListener(this.f50074c);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001261, new C1088a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static a d() {
        return f50071d;
    }

    public final GameInfoData b() {
        GameInfoData gameInfoData = new GameInfoData();
        gameInfoData.setGameName(TbadkApplication.getInst().getContext().getString(R.string.default_share_to_game_title));
        gameInfoData.setGameLink(this.f50073b);
        gameInfoData.setGameId("default");
        gameInfoData.setIconUrl("default");
        gameInfoData.setIntroduce(TbadkApplication.getInst().getContext().getString(R.string.default_share_to_game_content));
        return gameInfoData;
    }

    public GameInfoData c() {
        GameInfoData gameInfoData = this.f50072a;
        return gameInfoData == null ? b() : gameInfoData;
    }

    public ShareFromGameCenterMsgData e() {
        GameInfoData c2 = c();
        ShareFromGameCenterMsgData shareFromGameCenterMsgData = new ShareFromGameCenterMsgData();
        shareFromGameCenterMsgData.setTitle(StringUtils.isNull(GameShareJsBridge.getInstance().getShareTitle(), true) ? c2.getGameName() : GameShareJsBridge.getInstance().getShareTitle());
        shareFromGameCenterMsgData.setContent(StringUtils.isNull(GameShareJsBridge.getInstance().getShareContent(), true) ? c2.getIntroduce() : GameShareJsBridge.getInstance().getShareContent());
        shareFromGameCenterMsgData.setImageUrl(StringUtils.isNull(GameShareJsBridge.getInstance().getShareImage(), true) ? c2.getIconUrl() : GameShareJsBridge.getInstance().getShareImage());
        shareFromGameCenterMsgData.setShareSource(StringUtils.isNull(GameShareJsBridge.getInstance().getShareName(), true) ? c2.getGameName() : GameShareJsBridge.getInstance().getShareName());
        shareFromGameCenterMsgData.setShareSourceIcon(StringUtils.isNull(GameShareJsBridge.getInstance().getIconUrl(), true) ? c2.getIconUrl() : GameShareJsBridge.getInstance().getIconUrl());
        String gameId = StringUtils.isNull(GameShareJsBridge.getInstance().getGameId(), true) ? c2.getGameId() : GameShareJsBridge.getInstance().getGameId();
        if ("default".equals(gameId)) {
            shareFromGameCenterMsgData.setShareSourceUrl(gameId);
        } else {
            shareFromGameCenterMsgData.setShareSourceUrl("game:detail:TBCGameID=" + gameId);
        }
        String shareContentUrl = GameShareJsBridge.getInstance().getShareContentUrl();
        if (StringUtils.isNull(shareContentUrl)) {
            shareContentUrl = c2.getGameLink();
        }
        if (StringUtils.isNull(shareContentUrl, true)) {
            shareContentUrl = "";
        } else if (!shareContentUrl.contains("tbgametype")) {
            shareContentUrl = shareContentUrl + "&tbgametype=1";
        }
        shareFromGameCenterMsgData.setShareUrl(shareContentUrl.toString());
        return shareFromGameCenterMsgData;
    }
}
