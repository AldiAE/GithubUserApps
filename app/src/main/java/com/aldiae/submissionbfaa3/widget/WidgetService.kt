package com.aldiae.submissionbfaa3.widget

import android.content.Intent
import android.widget.RemoteViewsService

class WidgetService: RemoteViewsService() {
    override fun onGetViewFactory(p0: Intent?): RemoteViewsFactory {
        return WidgetDataProvider(this.applicationContext)
    }
}