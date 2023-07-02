//
//  ComposeView.swift
//  iosApp
//
//  Created by Rahul on 02/07/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

struct ComposeView:UIViewControllerRepresentable {
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {}
    
    func makeUIViewController(context: Context) -> some UIViewController {
        let viewController: UIViewController = AppKt.MainViewController(movieService: AppKt.createService())
        viewController.overrideUserInterfaceStyle = .light
        return viewController
    }
}
