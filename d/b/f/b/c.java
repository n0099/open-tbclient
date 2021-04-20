package d.b.f.b;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.audiorecorder.lib.voice.VoiceRecordButton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.b.h0.w.m;
/* loaded from: classes.dex */
public class c extends m {
    public c(Context context) {
        super(context, TbadkCoreApplication.getInst().getResources().getString(R.string.msglist_voice), 6);
        this.f51951d = R.drawable.icon_pure_post_voice_n_svg;
        this.f51952e = R.drawable.icon_mask_post_voice24_selection_svg;
        this.f51954g = true;
        this.l = 6;
        this.m = true;
        this.k = VoiceRecordButton.x(context);
        this.n = new int[]{1, 9};
    }

    @Override // d.b.h0.w.m
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
