package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.OnGamesLoadedListener;
import com.google.android.gms.games.OnPlayersLoadedListener;
import com.google.android.gms.games.OnSignOutCompleteListener;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.OnAchievementUpdatedListener;
import com.google.android.gms.games.achievement.OnAchievementsLoadedListener;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.OnLeaderboardMetadataLoadedListener;
import com.google.android.gms.games.leaderboard.OnLeaderboardScoresLoadedListener;
import com.google.android.gms.games.leaderboard.OnScoreSubmittedListener;
import com.google.android.gms.games.leaderboard.SubmitScoreResult;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.OnInvitationsLoadedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeReliableMessageSentListener;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.internal.bm;
import com.google.android.gms.internal.p;
import com.google.android.gms.internal.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public final class bj extends com.google.android.gms.internal.p {
    private final String f;
    private final String g;
    private final Map h;
    private final bn i;
    private boolean j;
    private final long k;
    private final boolean l;

    /* loaded from: classes.dex */
    abstract class a extends c {
        private final ArrayList b;

        a(RoomStatusUpdateListener roomStatusUpdateListener, com.google.android.gms.internal.k kVar, String[] strArr) {
            super(roomStatusUpdateListener, kVar);
            this.b = new ArrayList();
            for (String str : strArr) {
                this.b.add(str);
            }
        }

        @Override // com.google.android.gms.internal.bj.c
        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            if (roomStatusUpdateListener != null) {
                a(roomStatusUpdateListener, room, this.b);
            }
        }

        protected abstract void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList);
    }

    /* loaded from: classes.dex */
    final class aa extends a {
        aa(RoomStatusUpdateListener roomStatusUpdateListener, com.google.android.gms.internal.k kVar, String[] strArr) {
            super(roomStatusUpdateListener, kVar, strArr);
        }

        @Override // com.google.android.gms.internal.bj.a
        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.a(room, arrayList);
            }
        }
    }

    /* loaded from: classes.dex */
    final class ab extends a {
        ab(RoomStatusUpdateListener roomStatusUpdateListener, com.google.android.gms.internal.k kVar, String[] strArr) {
            super(roomStatusUpdateListener, kVar, strArr);
        }

        @Override // com.google.android.gms.internal.bj.a
        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.c(room, arrayList);
            }
        }
    }

    /* loaded from: classes.dex */
    final class ac extends a {
        ac(RoomStatusUpdateListener roomStatusUpdateListener, com.google.android.gms.internal.k kVar, String[] strArr) {
            super(roomStatusUpdateListener, kVar, strArr);
        }

        @Override // com.google.android.gms.internal.bj.a
        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.d(room, arrayList);
            }
        }
    }

    /* loaded from: classes.dex */
    final class ad extends bi {
        final /* synthetic */ bj a;
        private final OnPlayersLoadedListener b;

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void d(com.google.android.gms.internal.k kVar) {
            this.a.a(new ae(this.b, kVar));
        }
    }

    /* loaded from: classes.dex */
    final class ae extends p.c {
        ae(OnPlayersLoadedListener onPlayersLoadedListener, com.google.android.gms.internal.k kVar) {
            super(onPlayersLoadedListener, kVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(OnPlayersLoadedListener onPlayersLoadedListener) {
            onPlayersLoadedListener.a(this.d.b(), new PlayerBuffer(this.d));
        }
    }

    /* loaded from: classes.dex */
    final class af extends p.b {
        private final int b;
        private final String c;
        private final int d;

        af(RealTimeReliableMessageSentListener realTimeReliableMessageSentListener, int i, int i2, String str) {
            super(realTimeReliableMessageSentListener);
            this.b = i;
            this.d = i2;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.internal.p.b
        public void a(RealTimeReliableMessageSentListener realTimeReliableMessageSentListener) {
            if (realTimeReliableMessageSentListener != null) {
                realTimeReliableMessageSentListener.a(this.b, this.d, this.c);
            }
        }
    }

    /* loaded from: classes.dex */
    final class ag extends bi {
        final RealTimeReliableMessageSentListener a;
        final /* synthetic */ bj b;

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void a(int i, int i2, String str) {
            this.b.a(new af(this.a, i, i2, str));
        }
    }

    /* loaded from: classes.dex */
    final class ah extends c {
        ah(RoomStatusUpdateListener roomStatusUpdateListener, com.google.android.gms.internal.k kVar) {
            super(roomStatusUpdateListener, kVar);
        }

        @Override // com.google.android.gms.internal.bj.c
        public void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.b(room);
            }
        }
    }

    /* loaded from: classes.dex */
    final class ai extends bi {
        final /* synthetic */ bj a;
        private final RoomUpdateListener b;
        private final RoomStatusUpdateListener c;
        private final RealTimeMessageReceivedListener d;

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void a(RealTimeMessage realTimeMessage) {
            bk.a("GamesClient", "RoomBinderCallbacks: onRealTimeMessageReceived");
            this.a.a(new w(this.d, realTimeMessage));
        }

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void a(com.google.android.gms.internal.k kVar, String[] strArr) {
            this.a.a(new aa(this.c, kVar, strArr));
        }

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void b(com.google.android.gms.internal.k kVar, String[] strArr) {
            this.a.a(new ab(this.c, kVar, strArr));
        }

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void c(int i, String str) {
            this.a.a(new v(this.b, i, str));
        }

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void c(com.google.android.gms.internal.k kVar, String[] strArr) {
            this.a.a(new ac(this.c, kVar, strArr));
        }

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void d(com.google.android.gms.internal.k kVar, String[] strArr) {
            this.a.a(new y(this.c, kVar, strArr));
        }

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void e(com.google.android.gms.internal.k kVar, String[] strArr) {
            this.a.a(new x(this.c, kVar, strArr));
        }

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void f(com.google.android.gms.internal.k kVar, String[] strArr) {
            this.a.a(new z(this.c, kVar, strArr));
        }

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void m(com.google.android.gms.internal.k kVar) {
            this.a.a(new al(this.b, kVar));
        }

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void n(com.google.android.gms.internal.k kVar) {
            this.a.a(new q(this.b, kVar));
        }

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void o(com.google.android.gms.internal.k kVar) {
            this.a.a(new ak(this.c, kVar));
        }

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void p(com.google.android.gms.internal.k kVar) {
            this.a.a(new ah(this.c, kVar));
        }

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void q(com.google.android.gms.internal.k kVar) {
            this.a.a(new aj(this.b, kVar));
        }

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void r(com.google.android.gms.internal.k kVar) {
            this.a.a(new h(this.c, kVar));
        }

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void s(com.google.android.gms.internal.k kVar) {
            this.a.a(new i(this.c, kVar));
        }
    }

    /* loaded from: classes.dex */
    final class aj extends b {
        aj(RoomUpdateListener roomUpdateListener, com.google.android.gms.internal.k kVar) {
            super(roomUpdateListener, kVar);
        }

        @Override // com.google.android.gms.internal.bj.b
        public void a(RoomUpdateListener roomUpdateListener, Room room) {
            if (roomUpdateListener != null) {
                roomUpdateListener.c(this.d.b(), room);
            }
        }
    }

    /* loaded from: classes.dex */
    final class ak extends c {
        ak(RoomStatusUpdateListener roomStatusUpdateListener, com.google.android.gms.internal.k kVar) {
            super(roomStatusUpdateListener, kVar);
        }

        @Override // com.google.android.gms.internal.bj.c
        public void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.a(room);
            }
        }
    }

    /* loaded from: classes.dex */
    final class al extends b {
        public al(RoomUpdateListener roomUpdateListener, com.google.android.gms.internal.k kVar) {
            super(roomUpdateListener, kVar);
        }

        @Override // com.google.android.gms.internal.bj.b
        public void a(RoomUpdateListener roomUpdateListener, Room room) {
            roomUpdateListener.a(this.d.b(), room);
        }
    }

    /* loaded from: classes.dex */
    final class am extends bi {
        final /* synthetic */ bj a;
        private final OnSignOutCompleteListener b;

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void a() {
            this.a.a(new an(this.b));
        }
    }

    /* loaded from: classes.dex */
    final class an extends p.b {
        public an(OnSignOutCompleteListener onSignOutCompleteListener) {
            super(onSignOutCompleteListener);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.internal.p.b
        public void a(OnSignOutCompleteListener onSignOutCompleteListener) {
            onSignOutCompleteListener.a();
        }
    }

    /* loaded from: classes.dex */
    final class ao extends bi {
        final /* synthetic */ bj a;
        private final OnScoreSubmittedListener b;

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void c(com.google.android.gms.internal.k kVar) {
            this.a.a(new ap(this.b, new SubmitScoreResult(kVar)));
        }
    }

    /* loaded from: classes.dex */
    final class ap extends p.b {
        private final SubmitScoreResult b;

        public ap(OnScoreSubmittedListener onScoreSubmittedListener, SubmitScoreResult submitScoreResult) {
            super(onScoreSubmittedListener);
            this.b = submitScoreResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.internal.p.b
        public void a(OnScoreSubmittedListener onScoreSubmittedListener) {
            onScoreSubmittedListener.a(this.b.a(), this.b);
        }
    }

    /* loaded from: classes.dex */
    abstract class b extends p.c {
        b(RoomUpdateListener roomUpdateListener, com.google.android.gms.internal.k kVar) {
            super(roomUpdateListener, kVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(RoomUpdateListener roomUpdateListener) {
            a(roomUpdateListener, bj.this.a(this.d));
        }

        protected abstract void a(RoomUpdateListener roomUpdateListener, Room room);
    }

    /* loaded from: classes.dex */
    abstract class c extends p.c {
        c(RoomStatusUpdateListener roomStatusUpdateListener, com.google.android.gms.internal.k kVar) {
            super(roomStatusUpdateListener, kVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                a(roomStatusUpdateListener, bj.this.a(this.d));
            }
        }

        protected abstract void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    /* loaded from: classes.dex */
    final class d extends bi {
        final /* synthetic */ bj a;
        private final OnAchievementUpdatedListener b;

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void b(int i, String str) {
            this.a.a(new e(this.b, i, str));
        }
    }

    /* loaded from: classes.dex */
    final class e extends p.b {
        private final int b;
        private final String c;

        e(OnAchievementUpdatedListener onAchievementUpdatedListener, int i, String str) {
            super(onAchievementUpdatedListener);
            this.b = i;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(OnAchievementUpdatedListener onAchievementUpdatedListener) {
            onAchievementUpdatedListener.a(this.b, this.c);
        }
    }

    /* loaded from: classes.dex */
    final class f extends bi {
        final /* synthetic */ bj a;
        private final OnAchievementsLoadedListener b;

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void a(com.google.android.gms.internal.k kVar) {
            this.a.a(new g(this.b, kVar));
        }
    }

    /* loaded from: classes.dex */
    final class g extends p.c {
        g(OnAchievementsLoadedListener onAchievementsLoadedListener, com.google.android.gms.internal.k kVar) {
            super(onAchievementsLoadedListener, kVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(OnAchievementsLoadedListener onAchievementsLoadedListener) {
            onAchievementsLoadedListener.a(this.d.b(), new AchievementBuffer(this.d));
        }
    }

    /* loaded from: classes.dex */
    final class h extends c {
        h(RoomStatusUpdateListener roomStatusUpdateListener, com.google.android.gms.internal.k kVar) {
            super(roomStatusUpdateListener, kVar);
        }

        @Override // com.google.android.gms.internal.bj.c
        public void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.c(room);
            }
        }
    }

    /* loaded from: classes.dex */
    final class i extends c {
        i(RoomStatusUpdateListener roomStatusUpdateListener, com.google.android.gms.internal.k kVar) {
            super(roomStatusUpdateListener, kVar);
        }

        @Override // com.google.android.gms.internal.bj.c
        public void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.d(room);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class j extends t.a {
        private final p.d b;

        public j(p.d dVar) {
            this.b = dVar;
        }

        @Override // com.google.android.gms.internal.t
        public void a(int i, IBinder iBinder, Bundle bundle) {
            this.b.a(i, iBinder, bundle);
            if (i != 0 || bundle == null) {
                return;
            }
            bj.this.j = bundle.getBoolean("show_welcome_popup");
        }
    }

    /* loaded from: classes.dex */
    final class k extends bi {
        final /* synthetic */ bj a;
        private final OnGamesLoadedListener b;

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void f(com.google.android.gms.internal.k kVar) {
            this.a.a(new l(this.b, kVar));
        }
    }

    /* loaded from: classes.dex */
    final class l extends p.c {
        l(OnGamesLoadedListener onGamesLoadedListener, com.google.android.gms.internal.k kVar) {
            super(onGamesLoadedListener, kVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(OnGamesLoadedListener onGamesLoadedListener) {
            onGamesLoadedListener.a(this.d.b(), new GameBuffer(this.d));
        }
    }

    /* loaded from: classes.dex */
    final class m extends bi {
        final /* synthetic */ bj a;
        private final OnInvitationReceivedListener b;

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void j(com.google.android.gms.internal.k kVar) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(kVar);
            try {
                Invitation invitation = invitationBuffer.a() > 0 ? (Invitation) ((Invitation) invitationBuffer.b(0)).g() : null;
                if (invitation != null) {
                    this.a.a(new n(this.b, invitation));
                }
            } finally {
                invitationBuffer.b();
            }
        }
    }

    /* loaded from: classes.dex */
    final class n extends p.b {
        private final Invitation b;

        n(OnInvitationReceivedListener onInvitationReceivedListener, Invitation invitation) {
            super(onInvitationReceivedListener);
            this.b = invitation;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.a(this.b);
        }
    }

    /* loaded from: classes.dex */
    final class o extends bi {
        final /* synthetic */ bj a;
        private final OnInvitationsLoadedListener b;

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void i(com.google.android.gms.internal.k kVar) {
            this.a.a(new p(this.b, kVar));
        }
    }

    /* loaded from: classes.dex */
    final class p extends p.c {
        p(OnInvitationsLoadedListener onInvitationsLoadedListener, com.google.android.gms.internal.k kVar) {
            super(onInvitationsLoadedListener, kVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(OnInvitationsLoadedListener onInvitationsLoadedListener) {
            onInvitationsLoadedListener.a(this.d.b(), new InvitationBuffer(this.d));
        }
    }

    /* loaded from: classes.dex */
    final class q extends b {
        public q(RoomUpdateListener roomUpdateListener, com.google.android.gms.internal.k kVar) {
            super(roomUpdateListener, kVar);
        }

        @Override // com.google.android.gms.internal.bj.b
        public void a(RoomUpdateListener roomUpdateListener, Room room) {
            roomUpdateListener.b(this.d.b(), room);
        }
    }

    /* loaded from: classes.dex */
    final class r extends bi {
        final /* synthetic */ bj a;
        private final OnLeaderboardScoresLoadedListener b;

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void a(com.google.android.gms.internal.k kVar, com.google.android.gms.internal.k kVar2) {
            this.a.a(new s(this.b, kVar, kVar2));
        }
    }

    /* loaded from: classes.dex */
    final class s extends p.b {
        private final com.google.android.gms.internal.k b;
        private final com.google.android.gms.internal.k c;

        s(OnLeaderboardScoresLoadedListener onLeaderboardScoresLoadedListener, com.google.android.gms.internal.k kVar, com.google.android.gms.internal.k kVar2) {
            super(onLeaderboardScoresLoadedListener);
            this.b = kVar;
            this.c = kVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(OnLeaderboardScoresLoadedListener onLeaderboardScoresLoadedListener) {
            onLeaderboardScoresLoadedListener.a(this.c.b(), new LeaderboardBuffer(this.b), new LeaderboardScoreBuffer(this.c));
        }
    }

    /* loaded from: classes.dex */
    final class t extends bi {
        final /* synthetic */ bj a;
        private final OnLeaderboardMetadataLoadedListener b;

        @Override // com.google.android.gms.internal.bi, com.google.android.gms.internal.bl
        public void b(com.google.android.gms.internal.k kVar) {
            this.a.a(new u(this.b, kVar));
        }
    }

    /* loaded from: classes.dex */
    final class u extends p.c {
        u(OnLeaderboardMetadataLoadedListener onLeaderboardMetadataLoadedListener, com.google.android.gms.internal.k kVar) {
            super(onLeaderboardMetadataLoadedListener, kVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(OnLeaderboardMetadataLoadedListener onLeaderboardMetadataLoadedListener) {
            onLeaderboardMetadataLoadedListener.a(this.d.b(), new LeaderboardBuffer(this.d));
        }
    }

    /* loaded from: classes.dex */
    final class v extends p.b {
        private final int b;
        private final String c;

        v(RoomUpdateListener roomUpdateListener, int i, String str) {
            super(roomUpdateListener);
            this.b = i;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.internal.p.b
        public void a(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.a(this.b, this.c);
        }
    }

    /* loaded from: classes.dex */
    final class w extends p.b {
        private final RealTimeMessage b;

        w(RealTimeMessageReceivedListener realTimeMessageReceivedListener, RealTimeMessage realTimeMessage) {
            super(realTimeMessageReceivedListener);
            this.b = realTimeMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.internal.p.b
        public void a(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            bk.a("GamesClient", "Deliver Message received callback");
            if (realTimeMessageReceivedListener != null) {
                realTimeMessageReceivedListener.a(this.b);
            }
        }
    }

    /* loaded from: classes.dex */
    final class x extends a {
        x(RoomStatusUpdateListener roomStatusUpdateListener, com.google.android.gms.internal.k kVar, String[] strArr) {
            super(roomStatusUpdateListener, kVar, strArr);
        }

        @Override // com.google.android.gms.internal.bj.a
        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.e(room, arrayList);
            }
        }
    }

    /* loaded from: classes.dex */
    final class y extends a {
        y(RoomStatusUpdateListener roomStatusUpdateListener, com.google.android.gms.internal.k kVar, String[] strArr) {
            super(roomStatusUpdateListener, kVar, strArr);
        }

        @Override // com.google.android.gms.internal.bj.a
        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.b(room, arrayList);
            }
        }
    }

    /* loaded from: classes.dex */
    final class z extends a {
        z(RoomStatusUpdateListener roomStatusUpdateListener, com.google.android.gms.internal.k kVar, String[] strArr) {
            super(roomStatusUpdateListener, kVar, strArr);
        }

        @Override // com.google.android.gms.internal.bj.a
        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.f(room, arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Room a(com.google.android.gms.internal.k kVar) {
        by byVar = new by(kVar);
        try {
            return byVar.a() > 0 ? (Room) ((Room) byVar.b(0)).g() : null;
        } finally {
            byVar.b();
        }
    }

    private void l() {
        for (bo boVar : this.h.values()) {
            try {
                boVar.a();
            } catch (IOException e2) {
                bk.a("GamesClient", "IOException:", e2);
            }
        }
        this.h.clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p
    /* renamed from: a */
    public bm b(IBinder iBinder) {
        return bm.a.a(iBinder);
    }

    @Override // com.google.android.gms.internal.p
    public void a() {
        this.j = false;
        if (f()) {
            try {
                bm bmVar = (bm) k();
                bmVar.c();
                bmVar.b(this.k);
                bmVar.a(this.k);
            } catch (RemoteException e2) {
                bk.b("GamesClient", "Failed to notify client disconnect.");
            }
        }
        l();
        super.a();
    }

    public void a(IBinder iBinder, Bundle bundle) {
        if (f()) {
            try {
                ((bm) k()).a(iBinder, bundle);
            } catch (RemoteException e2) {
                bk.b("GamesClient", "service died");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p
    public void a(ConnectionResult connectionResult) {
        super.a(connectionResult);
        this.j = false;
    }

    @Override // com.google.android.gms.internal.p
    protected void a(com.google.android.gms.internal.u uVar, p.d dVar) {
        String locale = g().getResources().getConfiguration().locale.toString();
        j jVar = new j(dVar);
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.l);
        uVar.a(jVar, 3136100, g().getPackageName(), this.g, h(), this.f, this.i.b(), locale, bundle);
    }

    @Override // com.google.android.gms.internal.p
    protected String b() {
        return "com.google.android.gms.games.service.START";
    }

    @Override // com.google.android.gms.internal.p
    protected String c() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    @Override // com.google.android.gms.internal.p
    protected Bundle d() {
        try {
            Bundle b2 = ((bm) k()).b();
            if (b2 != null) {
                b2.setClassLoader(bj.class.getClassLoader());
                return b2;
            }
            return b2;
        } catch (RemoteException e2) {
            bk.b("GamesClient", "service died");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p
    public void e() {
        super.e();
        if (this.j) {
            this.i.a();
            this.j = false;
        }
    }
}
