package d.b.f.b;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.b.i0.w.m;
/* loaded from: classes.dex */
public class b extends m {
    public b(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(R.string.msglist_voice), 6);
        this.f52287d = R.drawable.icon_pure_post_voice24;
        this.f52288e = R.drawable.icon_pure_post_voice24_selection;
        this.f52290g = false;
        this.f52291h = true;
        this.l = 6;
        this.m = true;
        this.k = new NewVoiceRecordButton(context);
        this.n = new int[]{1, 9};
    }

    @Override // d.b.i0.w.m
    public boolean a() {
        if (!TbadkCoreApplication.getInst().isAudioRecorderOpen()) {
            String uegVoiceWarning = TbadkCoreApplication.getInst().getUegVoiceWarning();
            if (StringUtils.isNull(uegVoiceWarning)) {
                uegVoiceWarning = TbadkCoreApplication.getInst().getString(R.string.ueg_voice_warning);
            }
            UtilHelper.showToast(TbadkCoreApplication.getInst(), uegVoiceWarning);
            return false;
        }
        return super.a();
    }
}
