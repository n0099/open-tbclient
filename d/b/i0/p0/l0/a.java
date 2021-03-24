package d.b.i0.p0.l0;

import com.baidu.tieba.frs.HorseRace.LiveHorseRaceData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetHorseRaceLampList.DataRes;
import tbclient.GetHorseRaceLampList.LiveList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<LiveHorseRaceData> f57775a = new ArrayList();

    public List<LiveHorseRaceData> a() {
        return this.f57775a;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        new LiveHorseRaceData();
        List<LiveList> list = dataRes.live_list;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                LiveHorseRaceData liveHorseRaceData = new LiveHorseRaceData();
                liveHorseRaceData.parserProtobuf(list.get(i));
                this.f57775a.add(liveHorseRaceData);
            }
        }
    }
}
