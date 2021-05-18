package d.a.k0.q0.l0;

import com.baidu.tieba.frs.HorseRace.LiveHorseRaceData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetHorseRaceLampList.DataRes;
import tbclient.GetHorseRaceLampList.LiveList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<LiveHorseRaceData> f58710a = new ArrayList();

    public List<LiveHorseRaceData> a() {
        return this.f58710a;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        new LiveHorseRaceData();
        List<LiveList> list = dataRes.live_list;
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                LiveHorseRaceData liveHorseRaceData = new LiveHorseRaceData();
                liveHorseRaceData.parserProtobuf(list.get(i2));
                this.f58710a.add(liveHorseRaceData);
            }
        }
    }
}
